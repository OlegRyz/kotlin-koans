package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (year == other.year) {
            if (month == other.month) {
                return dayOfMonth - other.dayOfMonth
            } else {
                return  month - other.month
            }
        } else {
            return year - other.year
        }
    }

}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

data class MultiTimeInterval(val interval: TimeInterval, val multiplier: Int)


operator fun MyDate.plus(arg: TimeInterval): MyDate = addTimeIntervals(arg, 1)
operator fun MyDate.plus(arg: MultiTimeInterval): MyDate = addTimeIntervals(arg.interval, arg.multiplier)


operator fun TimeInterval.times(i: Int): MultiTimeInterval = MultiTimeInterval(this, i)


class DateRange(val start: MyDate, val endInclusive: MyDate) {
    operator fun contains(date: MyDate): Boolean {
        return start <= date && date <= endInclusive;
    }

    operator fun iterator(): Iterator<MyDate> = DateIterator(this)
}

class DateIterator(val dateRange: DateRange) : Iterator<MyDate> {
    var next = dateRange.start
    override fun next(): MyDate {
        var res = next
        next = next.nextDay()
        return res
    }

    override fun hasNext(): Boolean = next <= dateRange.endInclusive

}
