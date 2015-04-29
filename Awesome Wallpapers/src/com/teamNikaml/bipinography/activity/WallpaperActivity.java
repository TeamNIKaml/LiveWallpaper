package com.teamNikaml.bipinography.activity;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.teamNikaml.bipinography.app.AppController;
import com.teamNikaml.bipinography.fragment.GridFragment;
import com.teamNikaml.bipinography.picasa.model.Category;

public class WallpaperActivity extends Activity {

	// private DrawerLayout mDrawerLayout;
	// private ListView mDrawerList;
	// private ActionBarDrawerToggle mDrawerToggle;

	// Navigation drawer title
	private List<Category> albumsList;

	// private ArrayList<NavDrawerItem> navDrawerItems;
	// private NavDrawerListAdapter adapter;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		// mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

		// navDrawerItems = new ArrayList<NavDrawerItem>();

		// Getting the albums from shared preferences
		albumsList = AppController.getInstance().getPrefManger()
				.getCategories();

		// Insert "Recently Added" in navigation drawer first position

		// Loop through albums in add them to navigation drawer adapter
		for (Category a : albumsList) {
			// if(a.getTitle().equalsIgnoreCase("Ronaldo"))
			// navDrawerItems.add(new NavDrawerItem(a.getId(), a.getTitle()));
			System.out.println("###id title " + a.getId() + "," + a.getTitle());

		}

		Fragment fragment = GridFragment.newInstance("6142262527992176257");

		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction()
				.replace(R.id.frame_container_main, fragment).commit();

		// mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		// Setting the nav drawer list adapter
		// adapter = new NavDrawerListAdapter(getApplicationContext(),
		// navDrawerItems);
		// mDrawerList.setAdapter(adapter);

		// Enabling action bar app icon and behaving it as toggle button
		// getActionBar().setDisplayHomeAsUpEnabled(true);
		// getActionBar().setHomeButtonEnabled(true);
		// getActionBar().setIcon(
		// new ColorDrawable(getResources().getColor(
		// android.R.color.transparent)));

		// mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
		// R.drawable.ic_drawer, R.string.app_name, R.string.app_name) {

		// mDrawerLayout.setDrawerListener(mDrawerToggle);

	}

	/**
	 * Navigation drawer menu item click listener
	 * */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * On menu item selected
	 * */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// toggle nav drawer on selecting action bar app icon/title

		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_settings:
			// Selected settings menu item
			// launch Settings activity
			Intent intent = new Intent(this, SettingsActivity.class);
			startActivity(intent);
			break;
		case R.id.menu_about_us:
			startActivity(new Intent(getApplicationContext(), AboutUs.class));

			break;
			
		case R.id.menu_created_by:
			startActivity(new Intent(getApplicationContext(), CreatedBy.class));

			break;
			
		case R.id.menu_other_apps:
			//startActivity(new Intent(getApplicationContext(), CreatedBy.class));
			//market://search?q=pub:<publisher_name>
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:Nikhil Vijayakumar")));
			break;
			
			

		}
		return true;
	}

	/* *
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		// boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		// menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	/**
	 * Diplaying fragment view for selected nav drawer list item
	 * */
	/*
	 * private void displayView(int position) { // update the main content by
	 * replacing fragments Fragment fragment = null; switch (position) { case 0:
	 * // Recently added item selected // don't pass album id to home fragment
	 * fragment = GridFragment.newInstance(null); break;
	 * 
	 * default: // selected wallpaper category // send album id to home fragment
	 * to list all the wallpapers String albumId =
	 * albumsList.get(position).getId(); fragment =
	 * GridFragment.newInstance(albumId); break; }
	 * 
	 * if (fragment != null) { FragmentManager fragmentManager =
	 * getFragmentManager(); fragmentManager.beginTransaction()
	 * .replace(R.id.frame_container, fragment).commit();
	 * 
	 * // update selected item and title, then close the drawer //
	 * mDrawerList.setItemChecked(position, true); //
	 * mDrawerList.setSelection(position); //
	 * setTitle(albumsList.get(position).getTitle()); //
	 * mDrawerLayout.closeDrawer(mDrawerList); } else { // error in creating
	 * fragment Log.e(TAG, "Error in creating fragment"); } }
	 */

}
