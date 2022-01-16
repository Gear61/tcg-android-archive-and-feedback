package com.randomappsinc.techcareergrowth.settings

import android.content.Context
import android.content.res.Configuration
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager
import com.randomappsinc.techcareergrowth.theme.ThemeManager
import com.randomappsinc.techcareergrowth.theme.ThemeMode
import com.randomappsinc.techcareergrowth.util.UIUtil

open class SettingsAdapter(
    context: Context,
    protected var settingsSelectionListener: SettingsSelectionListener
) : RecyclerView.Adapter<SettingsAdapter.ViewHolder>()  {

    companion object {
        const val DARK_MODE_POSITION = 1
    }

    interface SettingsSelectionListener {
        fun onSettingsItemClicked(position: Int)
    }

    private var preferencesManager: PreferencesManager = PreferencesManager(context)
    private var options: MutableList<String> = mutableListOf(*context.resources.getStringArray(R.array.settings_options))
    private var icons: MutableList<String> = mutableListOf(*context.resources.getStringArray(R.array.settings_icons))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.settings_item_cell,
            parent,
            false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return options.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val iconView: TextView = itemView.findViewById(R.id.settings_icon)
        private val optionText: TextView = itemView.findViewById(R.id.settings_option_text)
        private val toggle: SwitchCompat = itemView.findViewById(R.id.settings_toggle)

        fun bind(position: Int) {
            iconView.text = icons[position]
            optionText.text = options[position]

            val resources = optionText.resources
            if (position == DARK_MODE_POSITION) {
                val darkModeFromSystem = preferencesManager.themeMode == ThemeMode.FOLLOW_SYSTEM &&
                        resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
                if (preferencesManager.themeMode == ThemeMode.DARK || darkModeFromSystem) {
                    UIUtil.setCheckedImmediately(toggle, true)
                } else {
                    UIUtil.setCheckedImmediately(toggle, false)
                }
                toggle.visibility = View.VISIBLE
                iconView.setTextSize(
                    TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.dark_mode_icon_size)
                )
            } else {
                toggle.visibility = View.GONE
                iconView.setTextSize(
                    TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.settings_icon_size)
                )
            }

            itemView.setOnClickListener {
                settingsSelectionListener.onSettingsItemClicked(bindingAdapterPosition)
            }

            toggle.setOnClickListener {
                val themeMode = if (toggle.isChecked) ThemeMode.DARK else ThemeMode.LIGHT
                preferencesManager.themeMode = themeMode
                ThemeManager.applyTheme(themeMode)
            }
        }
    }
}
