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
public class SensorReadingV1 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -115183323673947993L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SensorReadingV1\",\"namespace\":\"com.telemetry.info.avro\",\"fields\":[{\"name\":\"host\",\"type\":\"string\"},{\"name\":\"timestamp\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-nanos\"}},{\"name\":\"celcius\",\"type\":\"float\"},{\"name\":\"humidity\",\"type\":\"float\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<SensorReadingV1> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<SensorReadingV1> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<SensorReadingV1> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<SensorReadingV1> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<SensorReadingV1> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this SensorReadingV1 to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a SensorReadingV1 from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a SensorReadingV1 instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static SensorReadingV1 fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence host;
  private long timestamp;
  private float celcius;
  private float humidity;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SensorReadingV1() {}

  /**
   * All-args constructor.
   * @param host The new value for host
   * @param timestamp The new value for timestamp
   * @param celcius The new value for celcius
   * @param humidity The new value for humidity
   */
  public SensorReadingV1(java.lang.CharSequence host, java.lang.Long timestamp, java.lang.Float celcius, java.lang.Float humidity) {
    this.host = host;
    this.timestamp = timestamp;
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
    case 0: return host;
    case 1: return timestamp;
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
    case 0: host = (java.lang.CharSequence)value$; break;
    case 1: timestamp = (java.lang.Long)value$; break;
    case 2: celcius = (java.lang.Float)value$; break;
    case 3: humidity = (java.lang.Float)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'host' field.
   * @return The value of the 'host' field.
   */
  public java.lang.CharSequence getHost() {
    return host;
  }


  /**
   * Sets the value of the 'host' field.
   * @param value the value to set.
   */
  public void setHost(java.lang.CharSequence value) {
    this.host = value;
  }

  /**
   * Gets the value of the 'timestamp' field.
   * @return The value of the 'timestamp' field.
   */
  public long getTimestamp() {
    return timestamp;
  }


  /**
   * Sets the value of the 'timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(long value) {
    this.timestamp = value;
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
   * Creates a new SensorReadingV1 RecordBuilder.
   * @return A new SensorReadingV1 RecordBuilder
   */
  public static com.telemetry.info.avro.SensorReadingV1.Builder newBuilder() {
    return new com.telemetry.info.avro.SensorReadingV1.Builder();
  }

  /**
   * Creates a new SensorReadingV1 RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new SensorReadingV1 RecordBuilder
   */
  public static com.telemetry.info.avro.SensorReadingV1.Builder newBuilder(com.telemetry.info.avro.SensorReadingV1.Builder other) {
    if (other == null) {
      return new com.telemetry.info.avro.SensorReadingV1.Builder();
    } else {
      return new com.telemetry.info.avro.SensorReadingV1.Builder(other);
    }
  }

  /**
   * Creates a new SensorReadingV1 RecordBuilder by copying an existing SensorReadingV1 instance.
   * @param other The existing instance to copy.
   * @return A new SensorReadingV1 RecordBuilder
   */
  public static com.telemetry.info.avro.SensorReadingV1.Builder newBuilder(com.telemetry.info.avro.SensorReadingV1 other) {
    if (other == null) {
      return new com.telemetry.info.avro.SensorReadingV1.Builder();
    } else {
      return new com.telemetry.info.avro.SensorReadingV1.Builder(other);
    }
  }

  /**
   * RecordBuilder for SensorReadingV1 instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SensorReadingV1>
    implements org.apache.avro.data.RecordBuilder<SensorReadingV1> {

    private java.lang.CharSequence host;
    private long timestamp;
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
    private Builder(com.telemetry.info.avro.SensorReadingV1.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.host)) {
        this.host = data().deepCopy(fields()[0].schema(), other.host);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
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
     * Creates a Builder by copying an existing SensorReadingV1 instance
     * @param other The existing instance to copy.
     */
    private Builder(com.telemetry.info.avro.SensorReadingV1 other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.host)) {
        this.host = data().deepCopy(fields()[0].schema(), other.host);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = true;
      }
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
      * Gets the value of the 'host' field.
      * @return The value.
      */
    public java.lang.CharSequence getHost() {
      return host;
    }


    /**
      * Sets the value of the 'host' field.
      * @param value The value of 'host'.
      * @return This builder.
      */
    public com.telemetry.info.avro.SensorReadingV1.Builder setHost(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.host = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'host' field has been set.
      * @return True if the 'host' field has been set, false otherwise.
      */
    public boolean hasHost() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'host' field.
      * @return This builder.
      */
    public com.telemetry.info.avro.SensorReadingV1.Builder clearHost() {
      host = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'timestamp' field.
      * @return The value.
      */
    public long getTimestamp() {
      return timestamp;
    }


    /**
      * Sets the value of the 'timestamp' field.
      * @param value The value of 'timestamp'.
      * @return This builder.
      */
    public com.telemetry.info.avro.SensorReadingV1.Builder setTimestamp(long value) {
      validate(fields()[1], value);
      this.timestamp = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * @return This builder.
      */
    public com.telemetry.info.avro.SensorReadingV1.Builder clearTimestamp() {
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
    public com.telemetry.info.avro.SensorReadingV1.Builder setCelcius(float value) {
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
    public com.telemetry.info.avro.SensorReadingV1.Builder clearCelcius() {
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
    public com.telemetry.info.avro.SensorReadingV1.Builder setHumidity(float value) {
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
    public com.telemetry.info.avro.SensorReadingV1.Builder clearHumidity() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SensorReadingV1 build() {
      try {
        SensorReadingV1 record = new SensorReadingV1();
        record.host = fieldSetFlags()[0] ? this.host : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.timestamp = fieldSetFlags()[1] ? this.timestamp : (java.lang.Long) defaultValue(fields()[1]);
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
  private static final org.apache.avro.io.DatumWriter<SensorReadingV1>
    WRITER$ = (org.apache.avro.io.DatumWriter<SensorReadingV1>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<SensorReadingV1>
    READER$ = (org.apache.avro.io.DatumReader<SensorReadingV1>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.host);

    out.writeLong(this.timestamp);

    out.writeFloat(this.celcius);

    out.writeFloat(this.humidity);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.host = in.readString(this.host instanceof Utf8 ? (Utf8)this.host : null);

      this.timestamp = in.readLong();

      this.celcius = in.readFloat();

      this.humidity = in.readFloat();

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.host = in.readString(this.host instanceof Utf8 ? (Utf8)this.host : null);
          break;

        case 1:
          this.timestamp = in.readLong();
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










