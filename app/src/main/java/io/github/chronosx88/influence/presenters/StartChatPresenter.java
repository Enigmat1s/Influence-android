package io.github.chronosx88.influence.presenters;

import com.google.gson.JsonObject;

import io.github.chronosx88.influence.contracts.observer.Observer;
import io.github.chronosx88.influence.contracts.startchat.StartChatLogicContract;
import io.github.chronosx88.influence.contracts.startchat.StartChatPresenterContract;
import io.github.chronosx88.influence.contracts.startchat.StartChatViewContract;
import io.github.chronosx88.influence.helpers.AppHelper;
import io.github.chronosx88.influence.helpers.actions.UIActions;
import io.github.chronosx88.influence.logic.StartChatLogic;

public class StartChatPresenter implements StartChatPresenterContract, Observer {
    private StartChatViewContract view;
    private StartChatLogicContract logic;

    public StartChatPresenter(StartChatViewContract view) {
        this.view = view;
        this.logic = new StartChatLogic();
        AppHelper.getObservable().register(this);
    }

    @Override
    public void startChatWithPeer(String peerID) {
        view.showProgressDialog(true);
        logic.sendStartChatMessage(peerID);
    }

    @Override
    public void handleEvent(JsonObject object) {
        switch (object.get("action").getAsInt()) {
            case UIActions.PEER_NOT_EXIST: {
                view.showProgressDialog(false);
                view.showMessage("Данный узел не существует!");
                break;
            }

            case UIActions.NEW_CHAT: {
                view.showProgressDialog(false);
                view.showMessage("Чат успешно создан!");
                break;
            }
        }
    }
}
