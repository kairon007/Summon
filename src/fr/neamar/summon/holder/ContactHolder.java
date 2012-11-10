package fr.neamar.summon.holder;

import java.util.ArrayList;

import android.net.Uri;

public class ContactHolder extends Holder {
	public String lookupKey = "";
	
	public Uri icon = null;

	public ArrayList<String> phones = new ArrayList<String>();
	
	// How many times did we contact this person?
	public int timesContacted = 0;
	
	// Is this contact starred ?
	public Boolean starred = false;
}
