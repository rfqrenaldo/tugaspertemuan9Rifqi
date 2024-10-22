package com.example.tugaspertemuan9

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tugaspertemuan9.databinding.ActivityMain3Binding
import com.example.tugaspertemuan9.databinding.FragmentLoginBinding
import com.example.tugaspertemuan9.databinding.FragmentRegisterBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedViewModel: SharedViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    // Class-level variables to hold the received data
    private var email: String? = null
    private var password: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Get the shared ViewModel
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        // Observe the data from ViewModel
        sharedViewModel.email.observe(viewLifecycleOwner) { email ->
            binding.edtEmail.setText(email)
        }

        sharedViewModel.password.observe(viewLifecycleOwner) { password ->
            binding.edtPassword.setText(password)
        }

        with(binding) {
            btnLogin.setOnClickListener {
                // Collect data from inputs
                val enteredEmail = edtEmail.text.toString()
                val enteredPassword = edtPassword.text.toString()

                val sharedEmail = sharedViewModel.email.value
                val sharedPassword = sharedViewModel.password.value

                if (sharedEmail == enteredEmail && sharedPassword == enteredPassword) {
                    Intent(activity, MainActivity3::class.java).apply {
                        putExtra("EMAIL", sharedViewModel.email.value)
                        putExtra("PASSWORD", sharedViewModel.password.value)
                        putExtra("GENDER", sharedViewModel.gender.value)
                        putExtra("USERNAME", sharedViewModel.username.value)
                        putExtra("NUMBER", sharedViewModel.number.value)
                        startActivity(this)
                    }
                } else {
                    Toast.makeText(requireContext(), "Login failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}