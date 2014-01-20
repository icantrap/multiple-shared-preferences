package com.icantrap.examples.multiplesharedpreferences;

import android.app.Activity;
import android.os.Bundle;

public class SettingsActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    String settingsName = getIntent().getStringExtra("name");

    if (null != settingsName) {
      setTitle(settingsName);
    }

    // Display the fragment as the main content.
    getFragmentManager().beginTransaction()
      .replace(android.R.id.content, new SettingsFragment(settingsName))
      .commit();
  }
}
