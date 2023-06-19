package com.sathish.codelab.datastoreandroid.data

import kotlinx.coroutines.flow.flowOf
import java.text.SimpleDateFormat
import java.util.Locale

object ApiRepository {

    private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)

    // In a real app, this would be coming from a data source like a database
    val androidApiLevels = flowOf(
        listOf(
            AndroidApi(
                apiLevel = "1",
                name = "Android 1.0",
                launch = simpleDateFormat.parse("2008-01-01")!!,
                supportStopped = simpleDateFormat.parse("2010-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "1.1",
                name = "Android 1.1",
                launch = simpleDateFormat.parse("2009-01-01")!!,
                supportStopped = simpleDateFormat.parse("2010-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "1.5",
                name = "Cupcake",
                launch = simpleDateFormat.parse("2009-01-01")!!,
                supportStopped = simpleDateFormat.parse("2010-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "1.6",
                name = "Donut",
                launch = simpleDateFormat.parse("2009-01-01")!!,
                supportStopped = simpleDateFormat.parse("2011-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "2.0",
                name = "Eclair",
                launch = simpleDateFormat.parse("2009-01-01")!!,
                supportStopped = simpleDateFormat.parse("2012-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "2.1",
                name = "Eclair",
                launch = simpleDateFormat.parse("2010-01-01")!!,
                supportStopped = simpleDateFormat.parse("2012-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "2.2",
                name = "Froyo",
                launch = simpleDateFormat.parse("2010-01-01")!!,
                supportStopped = simpleDateFormat.parse("2013-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "2.3",
                name = "Gingerbread",
                launch = simpleDateFormat.parse("2010-01-01")!!,
                supportStopped = simpleDateFormat.parse("2014-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "3.0",
                name = "Honeycomb",
                launch = simpleDateFormat.parse("2011-01-01")!!,
                supportStopped = simpleDateFormat.parse("2017-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "3.1",
                name = "Honeycomb",
                launch = simpleDateFormat.parse("2011-01-01")!!,
                supportStopped = simpleDateFormat.parse("2017-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "4.0",
                name = "Ice Cream Sandwich",
                launch = simpleDateFormat.parse("2011-01-01")!!,
                supportStopped = simpleDateFormat.parse("2017-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "4.1",
                name = "Jelly Bean",
                launch = simpleDateFormat.parse("2012-01-01")!!,
                supportStopped = simpleDateFormat.parse("2018-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "4.2",
                name = "Jelly Bean",
                launch = simpleDateFormat.parse("2012-01-01")!!,
                supportStopped = simpleDateFormat.parse("2018-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "4.3",
                name = "Jelly Bean",
                launch = simpleDateFormat.parse("2013-01-01")!!,
                supportStopped = simpleDateFormat.parse("2018-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "5.0",
                name = "Lollipop",
                launch = simpleDateFormat.parse("2014-01-01")!!,
                supportStopped = simpleDateFormat.parse("2019-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "5.1",
                name = "Lollipop",
                launch = simpleDateFormat.parse("2015-01-01")!!,
                supportStopped = simpleDateFormat.parse("2019-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "6.0",
                name = "Marshmallow",
                launch = simpleDateFormat.parse("2015-01-01")!!,
                supportStopped = simpleDateFormat.parse("2020-01-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "7.0",
                name = "Nougat",
                launch = simpleDateFormat.parse("2016-01-01")!!,
                supportStopped = simpleDateFormat.parse("2021-08-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "7.1",
                name = "Nougat",
                launch = simpleDateFormat.parse("2016-12-01")!!,
                supportStopped = simpleDateFormat.parse("2021-08-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "8.0",
                name = "Oreo",
                launch = simpleDateFormat.parse("2017-08-21")!!,
                supportStopped = simpleDateFormat.parse("2021-02-28")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "8.1",
                name = "Oreo",
                launch = simpleDateFormat.parse("2017-12-05")!!,
                supportStopped = simpleDateFormat.parse("2023-02-28")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "9.0",
                name = "Pie",
                launch = simpleDateFormat.parse("2018-08-06")!!,
                supportStopped = simpleDateFormat.parse("2022-08-01")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "10",
                name = "Q",
                launch = simpleDateFormat.parse("2019-09-03")!!,
                supportStopped = simpleDateFormat.parse("2022-09-03")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "11",
                name = "R",
                launch = simpleDateFormat.parse("2020-09-08")!!,
                supportStopped = simpleDateFormat.parse("2023-09-08")!!,
                currentlySupported = false
            ),
            AndroidApi(
                apiLevel = "12",
                name = "S",
                launch = simpleDateFormat.parse("2021-10-18")!!,
                supportStopped = simpleDateFormat.parse("2023-09-07")!!,
                currentlySupported = true
            ),
            AndroidApi(
                apiLevel = "13",
                name = "T",
                launch = simpleDateFormat.parse("2022-10-12")!!,
                currentlySupported = false
            )
        )
    )
}
