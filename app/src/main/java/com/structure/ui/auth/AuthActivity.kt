package com.structure

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.structure.di.viewmodel.ViewModelProvidersFactory
import com.structure.model.UserModel
import com.structure.network.Result
import com.structure.ui.auth.AuthViewModel
import com.structure.ui.auth.TestFragment
import com.structure.ui.auth.TestViewModel
import com.structure.util.PreferenceManager
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject
import com.structure.ui.auth.SharedViewModel
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var preferenceManager: PreferenceManager

    @Inject
    lateinit var factoryProvider : ViewModelProvidersFactory

    lateinit var authViewModel : AuthViewModel

    lateinit var viewModel: TestViewModel

    var sharedViewModel: SharedViewModel? = null

    var TAG = AuthActivity::class.simpleName

//    @Inject var isAppNull : Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
//        Log.d(TAG,"is app null ? $isAppNull" )

//        AndroidInjection.inject(this)

        authViewModel= ViewModelProvider(this,factoryProvider).get(AuthViewModel::class.java)

        viewModel = ViewModelProvider(this,factoryProvider)
            .get(TestViewModel::class.java)

        sharedViewModel = ViewModelProvider(this,factoryProvider)
            .get(SharedViewModel::class.java)

        supportFragmentManager.beginTransaction().add(R.id.fragment,TestFragment()).commit()


//        authViewModel.allUsers.observe(this,object: Observer<UserModel> {
//            override fun onChanged(t: UserModel?) {
//                Toast.makeText(applicationContext,t?.name,Toast.LENGTH_LONG).show()
//
//            }
//        })

//        authViewModel.getSpecificUser(1,progressBar).observe(this,object: Observer<UserModel> {
//            override fun onChanged(t: UserModel?) {
//                Toast.makeText(this@AuthActivity,t?.name,Toast.LENGTH_LONG).show()
//            }
//        })


//        lifecycleScope.launch {
//
//            // scope bound to Activity Lifecycle
//        }

        login_button.setOnClickListener {
//            var value= preferenceManager.getInteger("test",0)
//            var value = preferenceManager.getObject("obj",UserModel::class.java)
//            Toast.makeText(this@AuthActivity,value?.name,Toast.LENGTH_LONG).show()
            sharedViewModel!!.data.value=user_id_input.text.toString()

        }

     preferenceManager.saveInteger("test",2)
        preferenceManager.saveObject("obj",UserModel(1,"khurram","khu001","gmail"))


//        authViewModel.getSpecificUser(1).observe(this,object: Observer<Result<UserModel>> {
//            override fun onChanged(result: Result<UserModel>?) {
//                when (result!!.status) {
//                    Result.Status.SUCCESS -> {
//                        progressBar.visibility=GONE
//                        Toast.makeText(this@AuthActivity,result.data!!.name,Toast.LENGTH_LONG).show()
//                    }
//                    Result.Status.LOADING -> progressBar.visibility= VISIBLE
//                    Result.Status.ERROR -> {
//                        progressBar.visibility=GONE
//                    }
//                }
//            }
//        })


        authViewModel.getSpecificUser1(1).observe(this,
            Observer{ result ->
                when (result!!.status) {
                    Result.Status.SUCCESS -> {
                        progressBar.visibility=GONE
                        Toast.makeText(this@AuthActivity,result.data!!.name,Toast.LENGTH_LONG).show()
                    }
                    Result.Status.LOADING -> progressBar.visibility= VISIBLE
                    Result.Status.ERROR -> {
                        progressBar.visibility=GONE
                    }
                }
            })

}



}
