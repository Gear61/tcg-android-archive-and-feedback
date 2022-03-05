package com.randomappsinc.techcareergrowth.settings

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import com.joanzapata.iconify.IconDrawable
import com.joanzapata.iconify.fonts.IoniconsIcons
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.databinding.OrderContentActivityBinding
import com.randomappsinc.techcareergrowth.home.MainActivity
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager
import com.randomappsinc.techcareergrowth.util.UIUtil

class OrderContentActivity : AppCompatActivity() {

    companion object {

        const val FROM_SETTINGS_KEY = "fromSettings"
    }

    private var fromSettings = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = OrderContentActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fromSettings = intent.getBooleanExtra(FROM_SETTINGS_KEY, false)
        if (fromSettings) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setHomeAsUpIndicator(
                IconDrawable(this, IoniconsIcons.ion_android_close)
                    .colorRes(R.color.white)
                    .actionBarSize()
            )
        }

        val preferencesManager = PreferencesManager.getInstance(this)
        val contentOrderingAdapter = ContentOrderingAdapter(lessonTypes = preferencesManager.getContentOrder())
        binding.lessonTypesList.adapter = contentOrderingAdapter

        val callback: ItemTouchHelper.Callback =
            SimpleItemTouchHelperCallback(contentOrderingAdapter)
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.lessonTypesList)

        binding.saveButton.setOnClickListener {
            preferencesManager.setContentOrder(contentOrderingAdapter.lessonTypes)
            UIUtil.showShortToast(R.string.order_saved, it.context)

            if (fromSettings) {
                finish()
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                overridePendingTransition(R.anim.fade_in, R.anim.stay)
                finish()
            }
        }
    }

    override fun finish() {
        super.finish()
        if (fromSettings) {
            overridePendingTransition(0, R.anim.slide_out_bottom)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
