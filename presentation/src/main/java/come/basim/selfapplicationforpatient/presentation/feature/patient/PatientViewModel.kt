package come.basim.selfapplicationforpatient.presentation.feature.patient

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import come.basim.selfapplicationforpatient.domin.model.patient.PatientRemotModel
import come.basim.selfapplicationforpatient.domin.usecase.GetPatientUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PatientViewModel @Inject constructor(private val getPatientUseCase: GetPatientUseCase) : ViewModel() {

    private val _patientStateFlow : MutableStateFlow<List<PatientRemotModel>> = MutableStateFlow(
        emptyList()
    )
    val patientStateFlow : StateFlow<List<PatientRemotModel>> = _patientStateFlow


    //loading
    private val _patientLoadingStateFlow : MutableStateFlow<Boolean> = MutableStateFlow( false )
    val patientLoadingStateFlow =_patientLoadingStateFlow.asStateFlow()

    //Erorr
    private val _patientErorrStateFlow : MutableStateFlow<Exception?> = MutableStateFlow(null)
    val patientErorrStateFlow =_patientErorrStateFlow.asStateFlow()


    init {
        getPatients()
    }

    fun getPatients(){
        viewModelScope.launch {
            _patientLoadingStateFlow.emit(true)
            try {
                _patientStateFlow.emit(getPatientUseCase())
            }catch (e:Exception){
                _patientErorrStateFlow.emit(e)
            }
            _patientLoadingStateFlow.emit(false)
        }
    }
}