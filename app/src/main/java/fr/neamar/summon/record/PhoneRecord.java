package fr.neamar.summon.record;

import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import fr.neamar.summon.R;
import fr.neamar.summon.holder.PhoneHolder;

public class PhoneRecord extends Record {
	public PhoneHolder phoneHolder;

	public PhoneRecord(PhoneHolder phoneHolder) {
		super();
		this.holder = this.phoneHolder = phoneHolder;
	}

	@Override
	public View display(Context context, View v) {
		if (v == null)
			v = inflateFromId(context, R.layout.item_phone);

		TextView appName = (TextView) v.findViewById(R.id.item_phone_text);
		appName.setText(enrichText(context.getString(R.string.ui_item_phone) + " \"{"
				+ phoneHolder.phone + "}\""));

		return v;
	}

	@Override
	public void doLaunch(Context context, View v) {
		Intent phone = new Intent(Intent.ACTION_CALL);
		phone.setData(Uri.parse("tel:" + phoneHolder.phone));

		phone.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		context.startActivity(phone);
	}

}
