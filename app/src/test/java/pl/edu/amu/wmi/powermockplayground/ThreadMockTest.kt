package pl.edu.amu.wmi.powermockplayground

import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PowerMockIgnore
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.rule.PowerMockRule
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * @author Eryk Mariankowski <eryk.mariankowski></eryk.mariankowski>@247.codes> on 20.05.18.
 */
@RunWith(RobolectricTestRunner::class)
@Config(
    constants = BuildConfig::class,
    sdk = [26]
)
@PowerMockIgnore("org.mockito.*", "org.robolectric.*", "android.*", "javax.xml.parsers.*", "com.sun.org.apache.xerces.internal.jaxp.*")
@PrepareForTest(AssertHelper::class)
class ThreadMockTest {

    @JvmField
    @Rule
    val rule = PowerMockRule()

    @Test
    fun shouldCreateActivity() {
        PowerMockito.mockStatic(Thread::class.java)
        val handler = Thread.UncaughtExceptionHandler { _, _ -> }
        PowerMockito.`when`(Thread.getDefaultUncaughtExceptionHandler()).thenReturn(handler)

        val activity = Robolectric
            .buildActivity(MainActivity::class.java)
            .create()
            .resume()
            .get()
        Assert.assertNotNull(activity)
    }
}
