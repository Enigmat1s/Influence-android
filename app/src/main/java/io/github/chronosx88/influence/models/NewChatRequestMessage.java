package io.github.chronosx88.influence.models;

import net.tomp2p.peers.PeerAddress;

import java.io.Serializable;
import java.util.UUID;

import io.github.chronosx88.influence.helpers.actions.NetworkActions;

public class NewChatRequestMessage extends BasicNetworkMessage implements Serializable {
    private String chatID;

    public NewChatRequestMessage(String chatID, String senderID, PeerAddress senderPeerAddress) {
        super(NetworkActions.CREATE_CHAT, senderID, senderPeerAddress);
        this.chatID = chatID;
    }

    public String getChatID() {
        return chatID;
    }
}
