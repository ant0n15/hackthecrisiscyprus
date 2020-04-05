package com.delivery.bakery.ui.product

import androidx.navigation.fragment.NavHostFragment
import com.delivery.bakery.R
import com.delivery.bakery.ui.base.BaseActivity
import kotlinx.android.synthetic.main.register_activity.*

class ProductActivity(
    override val layoutResourceId: Int = R.layout.product_activity
) : BaseActivity() {

    override fun onSupportNavigateUp() = NavHostFragment.findNavController(nav_host).navigateUp()
}
