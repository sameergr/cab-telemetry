/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.telemetry.info.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class SensorReadingInfluxV1 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8394143963681481280L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SensorReadingInfluxV1\",\"namespace\":\"com.telemetry.info.avro\",\"fields\":[{\"name\":\"measurement\",\"type\":\"string\"},{\"name\":\"tags\",\"type\":{\"type\":\"record\",\"name\":\"TagsRecord\",\"fields\":[{\"name\":\"host\",\"type\":\"string\"}]}},{\"name\":\"celcius\",\"type\":\"float\"},{\"name\":\"humidity\",\"type\":\"float\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<SensorReadingInfluxV1> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<SensorReadingInfluxV1> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<SensorReadingInfluxV1> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<SensorReadingInfluxV1> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<SensorReadingInfluxV1> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this SensorReadingInfluxV1 to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a SensorReadingInfluxV1 from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a SensorReadingInfluxV1 instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static SensorReadingInfluxV1 fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence measurement;
  private com.telemetry.info.avro.TagsRecord tags;
  private float celcius;
  private float humidity;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SensorReadingInfluxV1() {}

  /**
   * All-args constructor.
   * @param measurement The new value for measurement
   * @param tags The new value for tags
   * @param celcius The new value for celcius
   * @param humidity The new value for humidity
   */
  public SensorReadingInfluxV1(java.lang.CharSequence measurement, com.telemetry.info.avro.TagsRecord tags, java.lang.Float celcius, java.lang.Float humidity) {
    this.measurement = measurement;
    this.tags = tags;
    this.celcius = celcius;
    this.humidity = humidity;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return measurement;
    case 1: return tags;
    case 2: return celcius;
    case 3: return humidity;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: measurement = (java.lang.CharSequence)value$; break;
    case 1: tags = (com.telemetry.info.avro.TagsRecord)value$; break;
    case 2: celcius = (java.lang.Float)value$; break;
    case 3: humidity = (java.lang.Float)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'measurement' field.
   * @return The value of the 'measurement' field.
   */
  public java.lang.CharSequence getMeasurement() {
    return measurement;
  }


  /**
   * Sets the value of the 'measurement' field.
   * @param value the value to set.
   */
  public void setMeasurement(java.lang.CharSequence value) {
    this.measurement = value;
  }

  /**
   * Gets the value of the 'tags' field.
   * @return The value of the 'tags' field.
   */
  public com.telemetry.info.avro.TagsRecord getTags() {
    return tags;
  }


  /**
   * Sets the value of the 'tags' field.
   * @param value the value to set.
   */
  public void setTags(com.telemetry.info.avro.TagsRecord value) {
    this.tags = value;
  }

  /**
   * Gets the value of the 'celcius' field.
   * @return The value of the 'celcius' field.
   */
  public float getCelcius() {
    return celcius;
  }


  /**
   * Sets the value of the 'celcius' field.
   * @param value the value to set.
   */
  public void setCelcius(float value) {
    this.celcius = value;
  }

  /**
   * Gets the value of the 'humidity' field.
   * @return The value of the 'humidity' field.
   */
  public float getHumidity() {
    return humidity;
  }


  /**
   * Sets the value of the 'humidity' field.
   * @param value the value to set.
   */
  public void setHumidity(float value) {
    this.humidity = value;
  }

  /**
   * Creates a new SensorReadingInfluxV1 RecordBuilder.
   * @return A new SensorReadingInfluxV1 RecordBuilder
   */
  public static com.telemetry.info.avro.SensorReadingInfluxV1.Builder newBuilder() {
    return new com.telemetry.info.avro.SensorReadingInfluxV1.Builder();
  }

  /**
   * Creates a new SensorReadingInfluxV1 RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new SensorReadingInfluxV1 RecordBuilder
   */
  public static com.telemetry.info.avro.SensorReadingInfluxV1.Builder newBuilder(com.telemetry.info.avro.SensorReadingInfluxV1.Builder other) {
    if (other == null) {
      return new com.telemetry.info.avro.SensorReadingInfluxV1.Builder();
    } else {
      return new com.telemetry.info.avro.SensorReadingInfluxV1.Builder(other);
    }
  }

  /**
   * Creates a new SensorReadingInfluxV1 RecordBuilder by copying an existing SensorReadingInfluxV1 instance.
   * @param other The existing instance to copy.
   * @return A new SensorReadingInfluxV1 RecordBuilder
   */
  public static com.telemetry.info.avro.SensorReadingInfluxV1.Builder newBuilder(com.telemetry.info.avro.SensorReadingInfluxV1 other) {
    if (other == null) {
      return new com.telemetry.info.avro.SensorReadingInfluxV1.Builder();
    } else {
      return new com.telemetry.info.avro.SensorReadingInfluxV1.Builder(other);
    }
  }

  /**
   * RecordBuilder for SensorReadingInfluxV1 instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SensorReadingInfluxV1>
    implements org.apache.avro.data.RecordBuilder<SensorReadingInfluxV1> {

    private java.lang.CharSequence measurement;
    private com.telemetry.info.avro.TagsRecord tags;
    private com.telemetry.info.avro.TagsRecord.Builder tagsBuilder;
    private float celcius;
    private float humidity;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.telemetry.info.avro.SensorReadingInfluxV1.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.measurement)) {
        this.measurement = data().deepCopy(fields()[0].schema(), other.measurement);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.tags)) {
        this.tags = data().deepCopy(fields()[1].schema(), other.tags);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (other.hasTagsBuilder()) {
        this.tagsBuilder = com.telemetry.info.avro.TagsRecord.newBuilder(other.getTagsBuilder());
      }
      if (isValidValue(fields()[2], other.celcius)) {
        this.celcius = data().deepCopy(fields()[2].schema(), other.celcius);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.humidity)) {
        this.humidity = data().deepCopy(fields()[3].schema(), other.humidity);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing SensorReadingInfluxV1 instance
     * @param other The existing instance to copy.
     */
    private Builder(com.telemetry.info.avro.SensorReadingInfluxV1 other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.measurement)) {
        this.measurement = data().deepCopy(fields()[0].schema(), other.measurement);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.tags)) {
        this.tags = data().deepCopy(fields()[1].schema(), other.tags);
        fieldSetFlags()[1] = true;
      }
      this.tagsBuilder = null;
      if (isValidValue(fields()[2], other.celcius)) {
        this.celcius = data().deepCopy(fields()[2].schema(), other.celcius);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.humidity)) {
        this.humidity = data().deepCopy(fields()[3].schema(), other.humidity);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'measurement' field.
      * @return The value.
      */
    public java.lang.CharSequence getMeasurement() {
      return measurement;
    }


    /**
      * Sets the value of the 'measurement' field.
      * @param value The value of 'measurement'.
      * @return This builder.
      */
    public com.telemetry.info.avro.SensorReadingInfluxV1.Builder setMeasurement(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.measurement = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'measurement' field has been set.
      * @return True if the 'measurement' field has been set, false otherwise.
      */
    public boolean hasMeasurement() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'measurement' field.
      * @return This builder.
      */
    public com.telemetry.info.avro.SensorReadingInfluxV1.Builder clearMeasurement() {
      measurement = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'tags' field.
      * @return The value.
      */
    public com.telemetry.info.avro.TagsRecord getTags() {
      return tags;
    }


    /**
      * Sets the value of the 'tags' field.
      * @param value The value of 'tags'.
      * @return This builder.
      */
    public com.telemetry.info.avro.SensorReadingInfluxV1.Builder setTags(com.telemetry.info.avro.TagsRecord value) {
      validate(fields()[1], value);
      this.tagsBuilder = null;
      this.tags = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'tags' field has been set.
      * @return True if the 'tags' field has been set, false otherwise.
      */
    public boolean hasTags() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'tags' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.telemetry.info.avro.TagsRecord.Builder getTagsBuilder() {
      if (tagsBuilder == null) {
        if (hasTags()) {
          setTagsBuilder(com.telemetry.info.avro.TagsRecord.newBuilder(tags));
        } else {
          setTagsBuilder(com.telemetry.info.avro.TagsRecord.newBuilder());
        }
      }
      return tagsBuilder;
    }

    /**
     * Sets the Builder instance for the 'tags' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public com.telemetry.info.avro.SensorReadingInfluxV1.Builder setTagsBuilder(com.telemetry.info.avro.TagsRecord.Builder value) {
      clearTags();
      tagsBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'tags' field has an active Builder instance
     * @return True if the 'tags' field has an active Builder instance
     */
    public boolean hasTagsBuilder() {
      return tagsBuilder != null;
    }

    /**
      * Clears the value of the 'tags' field.
      * @return This builder.
      */
    public com.telemetry.info.avro.SensorReadingInfluxV1.Builder clearTags() {
      tags = null;
      tagsBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'celcius' field.
      * @return The value.
      */
    public float getCelcius() {
      return celcius;
    }


    /**
      * Sets the value of the 'celcius' field.
      * @param value The value of 'celcius'.
      * @return This builder.
      */
    public com.telemetry.info.avro.SensorReadingInfluxV1.Builder setCelcius(float value) {
      validate(fields()[2], value);
      this.celcius = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'celcius' field has been set.
      * @return True if the 'celcius' field has been set, false otherwise.
      */
    public boolean hasCelcius() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'celcius' field.
      * @return This builder.
      */
    public com.telemetry.info.avro.SensorReadingInfluxV1.Builder clearCelcius() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'humidity' field.
      * @return The value.
      */
    public float getHumidity() {
      return humidity;
    }


    /**
      * Sets the value of the 'humidity' field.
      * @param value The value of 'humidity'.
      * @return This builder.
      */
    public com.telemetry.info.avro.SensorReadingInfluxV1.Builder setHumidity(float value) {
      validate(fields()[3], value);
      this.humidity = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'humidity' field has been set.
      * @return True if the 'humidity' field has been set, false otherwise.
      */
    public boolean hasHumidity() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'humidity' field.
      * @return This builder.
      */
    public com.telemetry.info.avro.SensorReadingInfluxV1.Builder clearHumidity() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SensorReadingInfluxV1 build() {
      try {
        SensorReadingInfluxV1 record = new SensorReadingInfluxV1();
        record.measurement = fieldSetFlags()[0] ? this.measurement : (java.lang.CharSequence) defaultValue(fields()[0]);
        if (tagsBuilder != null) {
          try {
            record.tags = this.tagsBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("tags"));
            throw e;
          }
        } else {
          record.tags = fieldSetFlags()[1] ? this.tags : (com.telemetry.info.avro.TagsRecord) defaultValue(fields()[1]);
        }
        record.celcius = fieldSetFlags()[2] ? this.celcius : (java.lang.Float) defaultValue(fields()[2]);
        record.humidity = fieldSetFlags()[3] ? this.humidity : (java.lang.Float) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<SensorReadingInfluxV1>
    WRITER$ = (org.apache.avro.io.DatumWriter<SensorReadingInfluxV1>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<SensorReadingInfluxV1>
    READER$ = (org.apache.avro.io.DatumReader<SensorReadingInfluxV1>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.measurement);

    this.tags.customEncode(out);

    out.writeFloat(this.celcius);

    out.writeFloat(this.humidity);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.measurement = in.readString(this.measurement instanceof Utf8 ? (Utf8)this.measurement : null);

      if (this.tags == null) {
        this.tags = new com.telemetry.info.avro.TagsRecord();
      }
      this.tags.customDecode(in);

      this.celcius = in.readFloat();

      this.humidity = in.readFloat();

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.measurement = in.readString(this.measurement instanceof Utf8 ? (Utf8)this.measurement : null);
          break;

        case 1:
          if (this.tags == null) {
            this.tags = new com.telemetry.info.avro.TagsRecord();
          }
          this.tags.customDecode(in);
          break;

        case 2:
          this.celcius = in.readFloat();
          break;

        case 3:
          this.humidity = in.readFloat();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










