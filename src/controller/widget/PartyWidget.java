package controller.widget;

import model.party.Party;

public abstract class PartyWidget extends Widget {
    // Every widget that is linked to a party
    protected Party party;
    public PartyWidget(int x, int y, int width, int height, Party party) {
        super(x, y, width, height);
        this.party = party;
    }

    public Party getParty() {
        return party;
    }
}
