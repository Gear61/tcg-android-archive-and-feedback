package com.randomappsinc.techcareergrowth.settings

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import com.randomappsinc.techcareergrowth.databinding.OrderContentActivityBinding
import com.randomappsinc.techcareergrowth.home.MainActivity
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager

class OrderContentActivity : AppCompatActivity() {

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
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
