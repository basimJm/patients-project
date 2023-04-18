package come.basim.selfapplicationforpatient.data.di

import com.google.gson.Gson
import come.basim.selfapplicationforpatient.data.datasource.PatientDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton
import javax.sql.DataSource

@Module
@InstallIn(SingletonComponent::class)
    object NetworkModule {

       const val baseUrl = "https://patients-app-api.herokuapp.com/"

    @Provides
    @Singleton
    fun provideRetrofite() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideDataSource(retrofit: Retrofit):PatientDataSource{
        return retrofit.create(PatientDataSource::class.java)
    }

    }