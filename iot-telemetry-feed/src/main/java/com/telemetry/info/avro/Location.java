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
public class Location extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -92350984120375402L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Location\",\"namespace\":\"com.telemetry.info.avro\",\"fields\":[{\"name\":\"longitude\",\"type\":\"double\"},{\"name\":\"latitude\",\"type\":\"double\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Location> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Location> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Location> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Location> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Location> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Location to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Location from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Location instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Location fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private double longitude;
  private double latitude;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Location() {}

  /**
   * All-args constructor.
   * @param longitude The new value for longitude
   * @param latitude The new value for latitude
   */
  public Location(java.lang.Double longitude, java.lang.Double latitude) {
    this.longitude = longitude;
    this.latitude = latitude;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return longitude;
    case 1: return latitude;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: longitude = (java.lang.Double)value$; break;
    case 1: latitude = (java.lang.Double)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'longitude' field.
   * @return The value of the 'longitude' field.
   */
  public double getLongitude() {
    return longitude;
  }


  /**
   * Sets the value of the 'longitude' field.
   * @param value the value to set.
   */
  public void setLongitude(double value) {
    this.longitude = value;
  }

  /**
   * Gets the value of the 'latitude' field.
   * @return The value of the 'latitude' field.
   */
  public double getLatitude() {
    return latitude;
  }


  /**
   * Sets the value of the 'latitude' field.
   * @param value the value to set.
   */
  public void setLatitude(double value) {
    this.latitude = value;
  }

  /**
   * Creates a new Location RecordBuilder.
   * @return A new Location RecordBuilder
   */
  public static com.telemetry.info.avro.Location.Builder newBuilder() {
    return new com.telemetry.info.avro.Location.Builder();
  }

  /**
   * Creates a new Location RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Location RecordBuilder
   */
  public static com.telemetry.info.avro.Location.Builder newBuilder(com.telemetry.info.avro.Location.Builder other) {
    if (other == null) {
      return new com.telemetry.info.avro.Location.Builder();
    } else {
      return new com.telemetry.info.avro.Location.Builder(other);
    }
  }

  /**
   * Creates a new Location RecordBuilder by copying an existing Location instance.
   * @param other The existing instance to copy.
   * @return A new Location RecordBuilder
   */
  public static com.telemetry.info.avro.Location.Builder newBuilder(com.telemetry.info.avro.Location other) {
    if (other == null) {
      return new com.telemetry.info.avro.Location.Builder();
    } else {
      return new com.telemetry.info.avro.Location.Builder(other);
    }
  }

  /**
   * RecordBuilder for Location instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Location>
    implements org.apache.avro.data.RecordBuilder<Location> {

    private double longitude;
    private double latitude;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.telemetry.info.avro.Location.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.longitude)) {
        this.longitude = data().deepCopy(fields()[0].schema(), other.longitude);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.latitude)) {
        this.latitude = data().deepCopy(fields()[1].schema(), other.latitude);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing Location instance
     * @param other The existing instance to copy.
     */
    private Builder(com.telemetry.info.avro.Location other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.longitude)) {
        this.longitude = data().deepCopy(fields()[0].schema(), other.longitude);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.latitude)) {
        this.latitude = data().deepCopy(fields()[1].schema(), other.latitude);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'longitude' field.
      * @return The value.
      */
    public double getLongitude() {
      return longitude;
    }


    /**
      * Sets the value of the 'longitude' field.
      * @param value The value of 'longitude'.
      * @return This builder.
      */
    public com.telemetry.info.avro.Location.Builder setLongitude(double value) {
      validate(fields()[0], value);
      this.longitude = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'longitude' field has been set.
      * @return True if the 'longitude' field has been set, false otherwise.
      */
    public boolean hasLongitude() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'longitude' field.
      * @return This builder.
      */
    public com.telemetry.info.avro.Location.Builder clearLongitude() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'latitude' field.
      * @return The value.
      */
    public double getLatitude() {
      return latitude;
    }


    /**
      * Sets the value of the 'latitude' field.
      * @param value The value of 'latitude'.
      * @return This builder.
      */
    public com.telemetry.info.avro.Location.Builder setLatitude(double value) {
      validate(fields()[1], value);
      this.latitude = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'latitude' field has been set.
      * @return True if the 'latitude' field has been set, false otherwise.
      */
    public boolean hasLatitude() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'latitude' field.
      * @return This builder.
      */
    public com.telemetry.info.avro.Location.Builder clearLatitude() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Location build() {
      try {
        Location record = new Location();
        record.longitude = fieldSetFlags()[0] ? this.longitude : (java.lang.Double) defaultValue(fields()[0]);
        record.latitude = fieldSetFlags()[1] ? this.latitude : (java.lang.Double) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Location>
    WRITER$ = (org.apache.avro.io.DatumWriter<Location>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Location>
    READER$ = (org.apache.avro.io.DatumReader<Location>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeDouble(this.longitude);

    out.writeDouble(this.latitude);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.longitude = in.readDouble();

      this.latitude = in.readDouble();

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.longitude = in.readDouble();
          break;

        case 1:
          this.latitude = in.readDouble();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










