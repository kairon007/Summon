package fr.neamar.summon.record;

import android.content.Context;
import android.view.View;
import fr.neamar.summon.R;
import fr.neamar.summon.holder.AppHolder;
import fr.neamar.summon.holder.FavoriteHolder;

public class FavoriteRecord extends Record {
	public FavoriteHolder favoriteHolder;

	public FavoriteRecord(FavoriteHolder holder) {
		super();
		this.holder = this.favoriteHolder = holder;
	}

	@Override
	public View display(Context context, View v) {
		if (v == null)
			v = inflateFromId(context, R.layout.item_favorites);

		return v;
	}

	@Override
	public void doLaunch(Context context, View v) {
	}

}
