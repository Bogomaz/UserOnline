package ru.netology
val minute = 60;
val hour = 3600;
val day = 86400;

// Определяет, как давно пользователь был в сети и выводит сообщение в консоль
fun timeAgo(seconds: Int){
    when {
        seconds in 0..minute -> println("Был только что")
        seconds in (minute + 1)..(hour - 1) -> {
            val minutes = seconds / minute
            println("Был(а) $minutes "+formOfNoun(minutes, "минуту", "минуты", "минут")+" назад")
        }
        seconds in hour..day-1 -> {
            val hours = seconds / hour
            println("Был(а) $hours "+formOfNoun(hours, "час", "часа", "часов")+" назад")
        }
        seconds in (day ..(day * 2)) -> println("Был(а) вчера")
        seconds in (day * 2 + 1)..(day * 3) -> println("Был(а) позавчера")
        seconds > (day * 3) -> println("Был(а) давно")
    }
}

// Подбирает правильную форму слова
fun formOfNoun(count: Int, accusativeSingular: String, genetiveSingular: String, genetivePlural: String): String {
    return when {
        count % 10 == 1 && count % 100 != 11 -> accusativeSingular
        count % 10 in 2..4 && count % 100 !in 12..14 -> genetiveSingular
        else -> genetivePlural
    }
}


fun main() {
    timeAgo(30)        // Вывод: был(а) только что
    timeAgo(520)       // Вывод: был(а) 8 минут назад
    timeAgo(2400)      // Вывод: был(а) 40 минут назад
    timeAgo(90000)     // Вывод: был(а) вчера
    timeAgo(200000)    // Вывод: был(а) позавчера
    timeAgo(300000)    // Вывод: был(а) давно

    //проверить все формы слова минута
//    for(i in 60 .. 3600 step 60){
//        timeAgo(i);
//    }

    //проверить все формы слова час
//    for(i in 3600 .. 90000 step 3600){
//        timeAgo(i);
//    }
}
