package com.delivery.bakery.ui.register

import androidx.navigation.fragment.NavHostFragment
import com.delivery.bakery.ui.base.BaseActivity
import com.delivery.bakery.R
import kotlinx.android.synthetic.main.register_activity.*

class RegisterActivity(
    override val layoutResourceId: Int = R.layout.register_activity
) : BaseActivity() {

    override fun onSupportNavigateUp() = NavHostFragment.findNavController(nav_host).navigateUp()
}
