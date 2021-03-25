import kotlinx.datetime.Clock

actual fun systemCurrentTimeMillis(): Long {
    return Clock.System.now().toEpochMilliseconds()
}