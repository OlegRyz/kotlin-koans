
import iii_conventions.multiAssignemnt.MyDate
import iii_conventions.multiAssignemnt.isLeapDay
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class N30DestructuringDeclarationsKtTest {
    @Test fun testIsLeapDay() {
        assertTrue(isLeapDay(MyDate(2016, 2, 29)))
        assertFalse(isLeapDay(MyDate(2015, 2, 29)))
    }
}
