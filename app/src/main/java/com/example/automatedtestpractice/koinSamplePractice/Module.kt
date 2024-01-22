import com.example.automatedtestpractice.koinSamplePractice.Weather
import com.example.automatedtestpractice.koinSamplePractice.IWeather
import com.example.automatedtestpractice.koinSamplePractice.UmbrellaForKoin
import org.koin.dsl.module

val myModule = module {

    factory<IWeather> {
        Weather()
    }

    factory {
        UmbrellaForKoin(get())
    }

}


