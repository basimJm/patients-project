package come.basim.selfapplicationforpatient.presentation.feature.patient

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import come.basim.selfapplicationforpatient.domin.model.patient.PatientRemotModel
import come.basim.selfapplicationforpatient.presentation.databinding.FragmentPatientsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PatientFragment : Fragment() {

    lateinit var binding: FragmentPatientsBinding

    private val viewModel: PatientViewModel by viewModels()

   // private lateinit var adapter: PatientAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPatientsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initObserver()
        //initAdapter()
        // initListener()
    }

    // private fun initListener() {
    //     binding.swipeRefresh.setOnRefreshListener {
    //         viewModel.getPatients()
    //         lifecycleScope.launch {
    //             delay(5000)
    //             binding.swipeRefresh.isRefreshing=false
    //         }
    //     }
    // }

   //private fun initAdapter() {
   //   adapter = PatientAdapter()
   //   binding.recycleView.adapter = adapter

    //}

    private fun initObserver() {

        lifecycleScope.launch {
            viewModel.patientStateFlow.collect(){response->
                if (response.isNotEmpty()){
                    binding.recycleView.adapter=PatientAdapter(response)
                }
            }

        }

        lifecycleScope.launch {
            viewModel.patientLoadingStateFlow.collect() { show ->
                binding.progressLoading.isVisible = show
            }
        }

        lifecycleScope.launch() {
            viewModel.patientErorrStateFlow.collect() { e ->
                if (e != null) {
                    Log.d("TAGOO", e.toString())
                }
            }
        }
    }






}