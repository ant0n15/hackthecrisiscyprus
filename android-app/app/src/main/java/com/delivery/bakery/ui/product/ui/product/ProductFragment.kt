package com.delivery.bakery.ui.product.ui.product

import android.os.Bundle
import android.view.View
import com.delivery.bakery.R
import com.delivery.bakery.ui.base.BaseFragment
import javax.inject.Inject

class ProductFragment(
    override val layoutResourceId: Int = R.layout.product_fragment
) : BaseFragment() {

    @Inject
    lateinit var viewModel: ProductViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
    }
}
