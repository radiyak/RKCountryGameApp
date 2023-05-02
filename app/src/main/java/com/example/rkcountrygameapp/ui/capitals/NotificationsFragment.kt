package com.example.rkcountrygameapp.ui.capitals

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rkcountrygameapp.databinding.FragmentNotificationsBinding


class NotificationsFragment : Fragment() {
    var countrynamesarray=ArrayList<String>()

    var countrycapitalsarray=ArrayList<String>()

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        //fill countrynamesarray with country names
        countrynamesarray.add("Argentina")
        countrynamesarray.add("Australia")
        countrynamesarray.add("Bangladesh")
        countrynamesarray.add("Egypt")
        countrynamesarray.add("Nepal")
        countrynamesarray.add("Palestine")
        countrynamesarray.add("Switzerland")
        countrynamesarray.add("Turkey")
        countrynamesarray.add("United Arab Emirates")
        countrynamesarray.add("United States")
        countrynamesarray.sort()
        //fill countrycapitalsarray with capitals of the countries
        countrycapitalsarray.add("buenos aires")
        countrycapitalsarray.add("canberra")
        countrycapitalsarray.add("dhaka")
        countrycapitalsarray.add("cairo")
        countrycapitalsarray.add("kathmandu")
        countrycapitalsarray.add("jerusalem")
        countrycapitalsarray.add("bern")
        countrycapitalsarray.add("ankara")
        countrycapitalsarray.add("abu dhabi")
        countrycapitalsarray.add("washington, d.c.")

        val spin=binding.spinner2

        val adapt= getContext()?.let { ArrayAdapter(it, R.layout.simple_spinner_item,countrynamesarray) }
        spin.adapter=adapt

        spin.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                binding.capitalchecker.text=" "
                //when guess button is clicked, check answer for capital
                binding.capitalbutton.setOnClickListener() {
                    var answer = binding.guesstextbox.text.toString()
                    answer=answer.lowercase()
                    //if answer is correct, output correct
                    // else if blank, prompt for answer
                    // else output incorrect
                    if (answer==countrycapitalsarray[position]) {
                        binding.capitalchecker.text="That is correct."

                    }
                    else if (answer.isBlank()){
                        binding.capitalchecker.text="Please enter a capital."
                    }
                    else{
                        binding.capitalchecker.text="That is not correct."
                    }
                }


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                var y=0
            }

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}