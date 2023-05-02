package com.example.rkcountrygameapp.ui.locations

//import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rkcountrygameapp.databinding.FragmentDashboardBinding
import com.example.rkcountrygameapp.R

class DashboardFragment : Fragment() {
    var countrynamesarray=ArrayList<String>()
    var imagesarray=ArrayList<String>()
    var locationsarray=ArrayList<String>()

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        //fill arrays with country names, images, and location names
        countrynamesarray.add("United States")
        countrynamesarray.add("United Arab Emirates")
        countrynamesarray.add("Switzerland")
        countrynamesarray.add("Bangladesh")
        countrynamesarray.add("Eqypt")
        countrynamesarray.add("Turkey")
        countrynamesarray.add("Australia")
        countrynamesarray.add("Nepal")
        countrynamesarray.add("Argentina")

        countrynamesarray.add("Palestine")
        countrynamesarray.sort()
        //images array is filled with location images
        imagesarray.add("@drawable/argentina_iguazufalls")
        imagesarray.add("@drawable/australia_sydneyharbourbridge")
        imagesarray.add("@drawable/bangladesh_sundarban")
        imagesarray.add("@drawable/egypt_nileriver")
        imagesarray.add("@drawable/nepal_mounteverest")
        imagesarray.add("@drawable/palestine_domeoftherock")
        imagesarray.add("@drawable/switzerland_chilloncastle")
        imagesarray.add("@drawable/turkey_hagiasophia")
        imagesarray.add("@drawable/unitedarabemirates_burjkhalifa")
        imagesarray.add("@drawable/unitedstates_grandcanyon")


        imagesarray.sort()
        //location array is filled with location names
        locationsarray.add("iguazu falls")
        locationsarray.add("sydney harbour bridge")
        locationsarray.add("sundarban")
        locationsarray.add("nile river")
        locationsarray.add("mount everest")
        locationsarray.add("dome of the rock")
        locationsarray.add("chillon castle")
        locationsarray.add("hagia sophia")
        locationsarray.add("burj khalifa")
        locationsarray.add("grand canyon")


        //fill spinner with countrynames list
        val spin=binding.spinner

        val adapt= getContext()?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item,countrynamesarray) }
        spin.adapter=adapt
        //with spinner item is selected, display location image
        spin.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                binding.locationcheckertext.text=" "
                var imagename=imagesarray[position]
                var imageID= resources.getIdentifier(imagename, "@drawable",
                    getActivity()?.getPackageName()
                )
                binding.locationimageview.setImageResource(imageID)
                //when guess button is clicked, check if answer is correct
                binding.guesslocationbtn.setOnClickListener() {
                    var answer = binding.locationanswer.text.toString()
                    answer=answer.lowercase()
                    //if answer is correct, output correct.
                    // else if empty, prompt the user to enter
                    // else output incorrect
                    if (answer == locationsarray[position]) {
                        binding.locationcheckertext.text="That is correct."

                    }
                    else if (answer.isBlank()){
                        binding.locationcheckertext.text="Please enter a location."
                    }
                    else{
                        binding.locationcheckertext.text="That is not correct."
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