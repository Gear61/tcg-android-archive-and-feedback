package com.randomappsinc.techcareergrowth.settings

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.databinding.OrderContentActivityBinding
import com.randomappsinc.techcareergrowth.home.MainActivity
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager
import com.randomappsinc.techcareergrowth.util.UIUtil

class OrderContentActivity : AppCompatActivity() {

    companion object {

        const val FROM_SETTINGS_KEY = "fromSettings"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = OrderContentActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferencesManager = PreferencesManager(this)
        val contentOrderingAdapter = ContentOrderingAdapter(lessonTypes = preferencesManager.getContentOrder())
        binding.lessonTypesList.adapter = contentOrderingAdapter

        val callback: ItemTouchHelper.Callback =
            SimpleItemTouchHelperCallback(contentOrderingAdapter)
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.lessonTypesList)

        binding.saveButton.setOnClickListener {
            preferencesManager.setContentOrder(contentOrderingAdapter.lessonTypes)
            UIUtil.showShortToast(R.string.order_saved, it.context)

            val fromSettings = intent.getBooleanExtra(FROM_SETTINGS_KEY, false)
            if (fromSettings) {
                finish()
                overridePendingTransition(0, R.anim.slide_out_bottom)
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                overridePendingTransition(R.anim.fade_in, R.anim.stay)
                finish()
            }
        }
    }
}
