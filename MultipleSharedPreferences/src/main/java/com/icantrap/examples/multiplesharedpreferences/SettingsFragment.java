package com.icantrap.examples.multiplesharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
  private String settingsName;

  public SettingsFragment(String settingsName) {
    this.settingsName = settingsName;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (null != settingsName) {
      getPreferenceManager().setSharedPreferencesName(settingsName);
    }
    // Load the preferences from an XML resource
    addPreferencesFromResource(R.xml.preferences);
  }

  @Override
  public void onResume() {
    super.onResume();

    getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
  }

  @Override
  public void onPause() {
    super.onPause();

    getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
  }

  @Override
  public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    Preference preference = findPreference(key);

    if ("checkbox".equals(key)) {
      preference.setSummary(sharedPreferences.getBoolean(key, false) ? "checked" : "unchecked");
    }
    else if ("switch".equals(key)) {
      preference.setSummary(sharedPreferences.getBoolean(key, false) ? "on" : "off");
    }
    else if ("text".equals(key)) {
      preference.setSummary(sharedPreferences.getString(key, ""));
    }
  }
}
