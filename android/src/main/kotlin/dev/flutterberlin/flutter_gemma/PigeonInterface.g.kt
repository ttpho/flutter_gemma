// Autogenerated from Pigeon (v24.1.0), do not edit directly.
// See also: https://pub.dev/packages/pigeon
@file:Suppress("UNCHECKED_CAST", "ArrayInDataClass")

package dev.flutterberlin.flutter_gemma

import android.util.Log
import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MessageCodec
import io.flutter.plugin.common.StandardMethodCodec
import io.flutter.plugin.common.StandardMessageCodec
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

private fun wrapResult(result: Any?): List<Any?> {
  return listOf(result)
}

private fun wrapError(exception: Throwable): List<Any?> {
  return if (exception is FlutterError) {
    listOf(
      exception.code,
      exception.message,
      exception.details
    )
  } else {
    listOf(
      exception.javaClass.simpleName,
      exception.toString(),
      "Cause: " + exception.cause + ", Stacktrace: " + Log.getStackTraceString(exception)
    )
  }
}

/**
 * Error class for passing custom error details to Flutter via a thrown PlatformException.
 * @property code The error code.
 * @property message The error message.
 * @property details The error details. Must be a datatype supported by the api codec.
 */
class FlutterError (
  val code: String,
  override val message: String? = null,
  val details: Any? = null
) : Throwable()

enum class PreferredBackend(val raw: Int) {
  UNKNOWN(0),
  CPU(1),
  GPU(2),
  GPU_FLOAT16(3),
  GPU_MIXED(4),
  GPU_FULL(5),
  TPU(6);

  companion object {
    fun ofRaw(raw: Int): PreferredBackend? {
      return values().firstOrNull { it.raw == raw }
    }
  }
}
private open class PigeonInterfacePigeonCodec : StandardMessageCodec() {
  override fun readValueOfType(type: Byte, buffer: ByteBuffer): Any? {
    return when (type) {
      129.toByte() -> {
        return (readValue(buffer) as Long?)?.let {
          PreferredBackend.ofRaw(it.toInt())
        }
      }
      else -> super.readValueOfType(type, buffer)
    }
  }
  override fun writeValue(stream: ByteArrayOutputStream, value: Any?)   {
    when (value) {
      is PreferredBackend -> {
        stream.write(129)
        writeValue(stream, value.raw)
      }
      else -> super.writeValue(stream, value)
    }
  }
}


/** Generated interface from Pigeon that represents a handler of messages from Flutter. */
interface PlatformService {
  fun createModel(maxTokens: Long, modelPath: String, loraRanks: List<Long>?, preferredBackend: PreferredBackend?, maxNumImages: Long?, callback: (Result<Unit>) -> Unit)
  fun closeModel(callback: (Result<Unit>) -> Unit)
  fun createSession(temperature: Double, randomSeed: Long, topK: Long, topP: Double?, loraPath: String?, enableVisionModality: Boolean?, callback: (Result<Unit>) -> Unit)
  fun closeSession(callback: (Result<Unit>) -> Unit)
  fun sizeInTokens(prompt: String, callback: (Result<Long>) -> Unit)
  fun addQueryChunk(prompt: String, callback: (Result<Unit>) -> Unit)
  fun addImage(imageBytes: ByteArray, callback: (Result<Unit>) -> Unit)
  fun generateResponse(callback: (Result<String>) -> Unit)
  fun generateResponseAsync(callback: (Result<Unit>) -> Unit)

  companion object {
    /** The codec used by PlatformService. */
    val codec: MessageCodec<Any?> by lazy {
      PigeonInterfacePigeonCodec()
    }
    /** Sets up an instance of `PlatformService` to handle messages through the `binaryMessenger`. */
    @JvmOverloads
    fun setUp(binaryMessenger: BinaryMessenger, api: PlatformService?, messageChannelSuffix: String = "") {
      val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.flutter_gemma.PlatformService.createModel$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val maxTokensArg = args[0] as Long
            val modelPathArg = args[1] as String
            val loraRanksArg = args[2] as List<Long>?
            val preferredBackendArg = args[3] as PreferredBackend?
            val maxNumImagesArg = args[4] as Long?
            api.createModel(maxTokensArg, modelPathArg, loraRanksArg, preferredBackendArg, maxNumImagesArg) { result: Result<Unit> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                reply.reply(wrapResult(null))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.flutter_gemma.PlatformService.closeModel$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            api.closeModel{ result: Result<Unit> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                reply.reply(wrapResult(null))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.flutter_gemma.PlatformService.createSession$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val temperatureArg = args[0] as Double
            val randomSeedArg = args[1] as Long
            val topKArg = args[2] as Long
            val topPArg = args[3] as Double?
            val loraPathArg = args[4] as String?
            val enableVisionModalityArg = args[5] as Boolean?
            api.createSession(temperatureArg, randomSeedArg, topKArg, topPArg, loraPathArg, enableVisionModalityArg) { result: Result<Unit> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                reply.reply(wrapResult(null))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.flutter_gemma.PlatformService.closeSession$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            api.closeSession{ result: Result<Unit> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                reply.reply(wrapResult(null))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.flutter_gemma.PlatformService.sizeInTokens$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val promptArg = args[0] as String
            api.sizeInTokens(promptArg) { result: Result<Long> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                val data = result.getOrNull()
                reply.reply(wrapResult(data))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.flutter_gemma.PlatformService.addQueryChunk$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val promptArg = args[0] as String
            api.addQueryChunk(promptArg) { result: Result<Unit> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                reply.reply(wrapResult(null))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.flutter_gemma.PlatformService.addImage$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val imageBytesArg = args[0] as ByteArray
            api.addImage(imageBytesArg) { result: Result<Unit> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                reply.reply(wrapResult(null))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.flutter_gemma.PlatformService.generateResponse$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            api.generateResponse{ result: Result<String> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                val data = result.getOrNull()
                reply.reply(wrapResult(data))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.flutter_gemma.PlatformService.generateResponseAsync$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            api.generateResponseAsync{ result: Result<Unit> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                reply.reply(wrapResult(null))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
    }
  }
}
