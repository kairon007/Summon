package fr.neamar.summon.record;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import fr.neamar.summon.R;
import fr.neamar.summon.holder.AppHolder;

public class AppRecord extends Record {
	public AppHolder appHolder;

	protected final ComponentName className;

	public AppRecord(AppHolder appHolder) {
		super();
		this.holder = this.appHolder = appHolder;

		className = new ComponentName(appHolder.packageName, appHolder.activityName);
	}

	@Override
	public View display(Context context, View v) {
		if (v == null)
			v = inflateFromId(context, R.layout.item_app);

		TextView appName = (TextView) v.findViewById(R.id.item_app_name);
		appName.setText(enrichText(appHolder.displayName));

		ImageView appIcon = (ImageView) v.findViewById(R.id.item_app_icon);
		appIcon.setImageDrawable(this.getDrawable(context));

		return v;
	}
	
	@Override
	public Drawable getDrawable(Context context) {
		try {
			return context.getPackageManager().getActivityIcon(className);
		} catch (NameNotFoundException e) {
			return null;
		}
	}

	@Override
	public void doLaunch(Context context, View v) {
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		intent.setComponent(className);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);

		context.startActivity(intent);
	}
}
