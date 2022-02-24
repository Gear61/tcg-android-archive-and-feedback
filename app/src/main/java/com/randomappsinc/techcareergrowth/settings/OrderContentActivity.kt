package com.randomappsinc.techcareergrowth.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.randomappsinc.techcareergrowth.databinding.OrderContentActivityBinding
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager

class OrderContentActivity : AppCompatActivity() {

    var flashcardsList: RecyclerView? = null
    private lateinit var contentOrderingAdapter: ContentOrderingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = OrderContentActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferencesManager = PreferencesManager(this)
        contentOrderingAdapter = ContentOrderingAdapter(lessonTypes = preferencesManager.getContentOrder())
        flashcardsList!!.adapter = contentOrderingAdapter

        val callback: ItemTouchHelper.Callback =
            SimpleItemTouchHelperCallback(contentOrderingAdapter)
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(flashcardsList)
    }
}
