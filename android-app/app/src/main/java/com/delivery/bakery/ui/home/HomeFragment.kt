package com.delivery.bakery.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.delivery.bakery.R
import com.delivery.bakery.ui.base.BaseFragment
import com.delivery.bakery.ui.product.ProductActivity
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.register_fragment.*
import javax.inject.Inject

class HomeFragment(
    override val layoutResourceId: Int = R.layout.home_fragment
) : BaseFragment() {

    @Inject
    lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val greetingText = activity?.intent?.extras?.get("fullName")

        greeting.text = String.format(getString(R.string.greeting_text), greetingText)

        //viewModel.loadData()

        //viewModel.stores.observe(viewLifecycleOwner, Observer {
        //    Log.d("Stores", it.toString())
        //})

        bakery_info.setOnClickListener {
            val intent = Intent(context, ProductActivity::class.java)
            intent.putExtra("store_id", 1)
            startActivity(intent)
        }

    }
}
