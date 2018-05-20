package pl.edu.amu.wmi.powermockplayground

import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate
import org.powermock.modules.junit4.rule.PowerMockRule
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * @author Eryk Mariankowski <eryk.mariankowski></eryk.mariankowski>@247.codes> on 20.05.18.
 */
@RunWith(PowerMockRunner::class)
@PowerMockRunnerDelegate(RobolectricTestRunner::class)
@Config(
    constants = BuildConfig::class,
    sdk = [26]
)
@PrepareForTest(TestStatic::class)
class MainActivityTest {

    @JvmField
    @Rule
    val rule = PowerMockRule()

    @Test
    fun shouldCreateActivity() {
        PowerMockito.mockStatic(TestStatic::class.java)
        PowerMockito.`when`(TestStatic.testMsg()).thenReturn("hello mock")

        Assert.assertTrue(TestStatic.testMsg() == "hello mock")

        val activity = Robolectric
            .buildActivity(MainActivity::class.java)
            .create()
            .resume()
            .get()
        Assert.assertNotNull(activity)
    }
}