package com.delivery.bakery.ui.home

import androidx.navigation.fragment.NavHostFragment
import com.delivery.bakery.ui.base.BaseActivity
import com.delivery.bakery.R
import kotlinx.android.synthetic.main.register_activity.*

class HomeActivity(
    override val layoutResourceId: Int = R.layout.home_activity
) : BaseActivity() {

    override fun onSupportNavigateUp() = NavHostFragment.findNavController(nav_host).navigateUp()

}
