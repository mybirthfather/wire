// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: routeguide/RouteGuideProto.proto
package routeguide

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.TagHandler
import com.squareup.wire.WireField
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.String
import kotlin.jvm.JvmField
import okio.ByteString

data class Feature(
  @field:WireField(tag = 1, adapter = "com.squareup.wire.ProtoAdapter#STRING") val name: String? =
      null,
  @field:WireField(tag = 2, adapter = "routeguide.Point#ADAPTER") val location: Point? = null,
  val unknownFields: ByteString = ByteString.EMPTY
) : Message<Feature, Feature.Builder>(ADAPTER, unknownFields) {
  @Deprecated(
      message = "Shouldn't be used in Kotlin",
      level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Builder = Builder(this.copy())

  class Builder(private val message: Feature) : Message.Builder<Feature, Builder>() {
    override fun build(): Feature = message
  }

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<Feature> = object : ProtoAdapter<Feature>(
      FieldEncoding.LENGTH_DELIMITED, 
      Feature::class.java
    ) {
      override fun encodedSize(value: Feature): Int = 
        ProtoAdapter.STRING.encodedSizeWithTag(1, value.name) +
        Point.ADAPTER.encodedSizeWithTag(2, value.location) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: Feature) {
        ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name)
        Point.ADAPTER.encodeWithTag(writer, 2, value.location)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): Feature {
        var name: String? = null
        var location: Point? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> name = ProtoAdapter.STRING.decode(reader)
            2 -> location = Point.ADAPTER.decode(reader)
            else -> TagHandler.UNKNOWN_TAG
          }
        }
        return Feature(
          name = name,
          location = location,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: Feature): Feature? = value.copy(
        location = value.location?.let(Point.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }
  }
}
