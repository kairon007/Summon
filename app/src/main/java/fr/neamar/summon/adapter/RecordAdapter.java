package fr.neamar.summon.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import fr.neamar.summon.QueryInterface;
import fr.neamar.summon.record.AppRecord;
import fr.neamar.summon.record.ContactRecord;
import fr.neamar.summon.record.PhoneRecord;
import fr.neamar.summon.record.Record;
import fr.neamar.summon.record.SearchRecord;
import fr.neamar.summon.record.SettingRecord;
import fr.neamar.summon.record.ToggleRecord;

public class RecordAdapter extends ArrayAdapter<Record> {

	/**
	 * Array list containing all the records currently displayed
	 */
	private ArrayList<Record> records = new ArrayList<Record>();

	private QueryInterface parent;

	public RecordAdapter(Context context, QueryInterface parent, int textViewResourceId,
			ArrayList<Record> records) {
		super(context, textViewResourceId, records);

		this.parent = parent;
		this.records = records;
	}

	public int getViewTypeCount() {
		return 6;
	}

	public int getItemViewType(int position) {
		if (records.get(position) instanceof AppRecord)
			return 0;
		else if (records.get(position) instanceof SearchRecord)
			return 1;
		else if (records.get(position) instanceof ContactRecord)
			return 2;
		else if (records.get(position) instanceof ToggleRecord)
			return 3;
		else if (records.get(position) instanceof SettingRecord)
			return 4;
		else if (records.get(position) instanceof SettingRecord)
			return 4;
		else if (records.get(position) instanceof PhoneRecord)
			return 5;
		else
			return -1;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return records.get(position).display(getContext(), convertView);
	}

	public void onLongClick(int pos) {
		records.get(pos).deleteRecord(getContext());
		records.remove(pos);
		Toast.makeText(getContext(), "Removed from history", Toast.LENGTH_SHORT).show();
		notifyDataSetChanged();
	}

	public void onClick(int position, View v) {
		try {
			records.get(position).launch(getContext(), v);
		} catch (ArrayIndexOutOfBoundsException e) {

		}

		parent.launchOccured();
	}
}
