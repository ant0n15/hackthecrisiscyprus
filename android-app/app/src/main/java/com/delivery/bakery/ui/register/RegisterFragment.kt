package com.delivery.bakery.ui.register

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.delivery.bakery.R
import com.delivery.bakery.ui.base.BaseFragment
import com.delivery.bakery.ui.home.HomeActivity
import kotlinx.android.synthetic.main.register_fragment.*

class RegisterFragment(
    override val layoutResourceId: Int = R.layout.register_fragment
) : BaseFragment() {

    private lateinit var viewModel: RegisterViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        // TODO: Use the ViewModel

        register.setOnClickListener {
            val intent = Intent(context, HomeActivity::class.java)
            intent.putExtra("fullName", et_full_name.text)
            startActivity(intent)
        }
    }
}
