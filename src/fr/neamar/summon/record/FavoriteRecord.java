package fr.neamar.summon.record;

import android.content.Context;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import fr.neamar.summon.R;
import fr.neamar.summon.holder.FavoriteHolder;

public class FavoriteRecord extends Record {
	public FavoriteHolder favoriteHolder;

	public FavoriteRecord(FavoriteHolder holder) {
		super();
		this.holder = this.favoriteHolder = holder;
	}
	
	private View.OnCreateContextMenuListener contextMenu = new View.OnCreateContextMenuListener() {

		@Override
		public void onCreateContextMenu(ContextMenu arg0, View arg1,
				ContextMenuInfo arg2) {
			// TODO Auto-generated method stub
			arg0.add(0, 0, 0, "Call");
			arg0.add(0, 1, 0, "Map");
			arg0.add(0, 2, 0, "Market");

		}
	};

	@Override
	public View display(Context context, View v) {
		if (v == null)
		{
			v = inflateFromId(context, R.layout.item_favorites);

			ImageButton favorites = (ImageButton) v.findViewById(R.id.item_favorites_favorites0);
			favorites.setOnCreateContextMenuListener(contextMenu);

			favorites.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					v.showContextMenu();
				}
			});
		}
		
		return v;
	}

	@Override
	public void doLaunch(Context context, View v) {
	}

}
