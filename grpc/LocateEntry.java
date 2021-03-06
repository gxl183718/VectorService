// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vector.proto

package iie.grpc;

/**
 * Protobuf type {@code LocateEntry}
 */
public  final class LocateEntry extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:LocateEntry)
    LocateEntryOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LocateEntry.newBuilder() to construct.
  private LocateEntry(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LocateEntry() {
    type_ = "";
    label_ = "";
    vector_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LocateEntry(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            x1_ = input.readSInt32();
            break;
          }
          case 16: {

            y1_ = input.readSInt32();
            break;
          }
          case 24: {

            x2_ = input.readSInt32();
            break;
          }
          case 32: {

            y2_ = input.readSInt32();
            break;
          }
          case 40: {

            x3_ = input.readSInt32();
            break;
          }
          case 48: {

            y3_ = input.readSInt32();
            break;
          }
          case 56: {

            x4_ = input.readSInt32();
            break;
          }
          case 64: {

            y4_ = input.readSInt32();
            break;
          }
          case 74: {
            java.lang.String s = input.readStringRequireUtf8();

            type_ = s;
            break;
          }
          case 82: {
            java.lang.String s = input.readStringRequireUtf8();

            label_ = s;
            break;
          }
          case 90: {

            vector_ = input.readBytes();
            break;
          }
          case 101: {

            similarity_ = input.readFloat();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return iie.grpc.VectorServer.internal_static_LocateEntry_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return iie.grpc.VectorServer.internal_static_LocateEntry_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            iie.grpc.LocateEntry.class, iie.grpc.LocateEntry.Builder.class);
  }

  public static final int X1_FIELD_NUMBER = 1;
  private int x1_;
  /**
   * <code>sint32 x1 = 1;</code>
   */
  public int getX1() {
    return x1_;
  }

  public static final int Y1_FIELD_NUMBER = 2;
  private int y1_;
  /**
   * <code>sint32 y1 = 2;</code>
   */
  public int getY1() {
    return y1_;
  }

  public static final int X2_FIELD_NUMBER = 3;
  private int x2_;
  /**
   * <code>sint32 x2 = 3;</code>
   */
  public int getX2() {
    return x2_;
  }

  public static final int Y2_FIELD_NUMBER = 4;
  private int y2_;
  /**
   * <code>sint32 y2 = 4;</code>
   */
  public int getY2() {
    return y2_;
  }

  public static final int X3_FIELD_NUMBER = 5;
  private int x3_;
  /**
   * <code>sint32 x3 = 5;</code>
   */
  public int getX3() {
    return x3_;
  }

  public static final int Y3_FIELD_NUMBER = 6;
  private int y3_;
  /**
   * <code>sint32 y3 = 6;</code>
   */
  public int getY3() {
    return y3_;
  }

  public static final int X4_FIELD_NUMBER = 7;
  private int x4_;
  /**
   * <code>sint32 x4 = 7;</code>
   */
  public int getX4() {
    return x4_;
  }

  public static final int Y4_FIELD_NUMBER = 8;
  private int y4_;
  /**
   * <code>sint32 y4 = 8;</code>
   */
  public int getY4() {
    return y4_;
  }

  public static final int TYPE_FIELD_NUMBER = 9;
  private volatile java.lang.Object type_;
  /**
   * <code>string type = 9;</code>
   */
  public java.lang.String getType() {
    java.lang.Object ref = type_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      type_ = s;
      return s;
    }
  }
  /**
   * <code>string type = 9;</code>
   */
  public com.google.protobuf.ByteString
      getTypeBytes() {
    java.lang.Object ref = type_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      type_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LABEL_FIELD_NUMBER = 10;
  private volatile java.lang.Object label_;
  /**
   * <code>string label = 10;</code>
   */
  public java.lang.String getLabel() {
    java.lang.Object ref = label_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      label_ = s;
      return s;
    }
  }
  /**
   * <code>string label = 10;</code>
   */
  public com.google.protobuf.ByteString
      getLabelBytes() {
    java.lang.Object ref = label_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      label_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int VECTOR_FIELD_NUMBER = 11;
  private com.google.protobuf.ByteString vector_;
  /**
   * <code>bytes vector = 11;</code>
   */
  public com.google.protobuf.ByteString getVector() {
    return vector_;
  }

  public static final int SIMILARITY_FIELD_NUMBER = 12;
  private float similarity_;
  /**
   * <code>float similarity = 12;</code>
   */
  public float getSimilarity() {
    return similarity_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (x1_ != 0) {
      output.writeSInt32(1, x1_);
    }
    if (y1_ != 0) {
      output.writeSInt32(2, y1_);
    }
    if (x2_ != 0) {
      output.writeSInt32(3, x2_);
    }
    if (y2_ != 0) {
      output.writeSInt32(4, y2_);
    }
    if (x3_ != 0) {
      output.writeSInt32(5, x3_);
    }
    if (y3_ != 0) {
      output.writeSInt32(6, y3_);
    }
    if (x4_ != 0) {
      output.writeSInt32(7, x4_);
    }
    if (y4_ != 0) {
      output.writeSInt32(8, y4_);
    }
    if (!getTypeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 9, type_);
    }
    if (!getLabelBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 10, label_);
    }
    if (!vector_.isEmpty()) {
      output.writeBytes(11, vector_);
    }
    if (similarity_ != 0F) {
      output.writeFloat(12, similarity_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (x1_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(1, x1_);
    }
    if (y1_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(2, y1_);
    }
    if (x2_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(3, x2_);
    }
    if (y2_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(4, y2_);
    }
    if (x3_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(5, x3_);
    }
    if (y3_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(6, y3_);
    }
    if (x4_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(7, x4_);
    }
    if (y4_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(8, y4_);
    }
    if (!getTypeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(9, type_);
    }
    if (!getLabelBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, label_);
    }
    if (!vector_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(11, vector_);
    }
    if (similarity_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(12, similarity_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof iie.grpc.LocateEntry)) {
      return super.equals(obj);
    }
    iie.grpc.LocateEntry other = (iie.grpc.LocateEntry) obj;

    if (getX1()
        != other.getX1()) return false;
    if (getY1()
        != other.getY1()) return false;
    if (getX2()
        != other.getX2()) return false;
    if (getY2()
        != other.getY2()) return false;
    if (getX3()
        != other.getX3()) return false;
    if (getY3()
        != other.getY3()) return false;
    if (getX4()
        != other.getX4()) return false;
    if (getY4()
        != other.getY4()) return false;
    if (!getType()
        .equals(other.getType())) return false;
    if (!getLabel()
        .equals(other.getLabel())) return false;
    if (!getVector()
        .equals(other.getVector())) return false;
    if (java.lang.Float.floatToIntBits(getSimilarity())
        != java.lang.Float.floatToIntBits(
            other.getSimilarity())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + X1_FIELD_NUMBER;
    hash = (53 * hash) + getX1();
    hash = (37 * hash) + Y1_FIELD_NUMBER;
    hash = (53 * hash) + getY1();
    hash = (37 * hash) + X2_FIELD_NUMBER;
    hash = (53 * hash) + getX2();
    hash = (37 * hash) + Y2_FIELD_NUMBER;
    hash = (53 * hash) + getY2();
    hash = (37 * hash) + X3_FIELD_NUMBER;
    hash = (53 * hash) + getX3();
    hash = (37 * hash) + Y3_FIELD_NUMBER;
    hash = (53 * hash) + getY3();
    hash = (37 * hash) + X4_FIELD_NUMBER;
    hash = (53 * hash) + getX4();
    hash = (37 * hash) + Y4_FIELD_NUMBER;
    hash = (53 * hash) + getY4();
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getType().hashCode();
    hash = (37 * hash) + LABEL_FIELD_NUMBER;
    hash = (53 * hash) + getLabel().hashCode();
    hash = (37 * hash) + VECTOR_FIELD_NUMBER;
    hash = (53 * hash) + getVector().hashCode();
    hash = (37 * hash) + SIMILARITY_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getSimilarity());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static iie.grpc.LocateEntry parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static iie.grpc.LocateEntry parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static iie.grpc.LocateEntry parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static iie.grpc.LocateEntry parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static iie.grpc.LocateEntry parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static iie.grpc.LocateEntry parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static iie.grpc.LocateEntry parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static iie.grpc.LocateEntry parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static iie.grpc.LocateEntry parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static iie.grpc.LocateEntry parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static iie.grpc.LocateEntry parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static iie.grpc.LocateEntry parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(iie.grpc.LocateEntry prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code LocateEntry}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:LocateEntry)
      iie.grpc.LocateEntryOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return iie.grpc.VectorServer.internal_static_LocateEntry_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return iie.grpc.VectorServer.internal_static_LocateEntry_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              iie.grpc.LocateEntry.class, iie.grpc.LocateEntry.Builder.class);
    }

    // Construct using iie.grpc.LocateEntry.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      x1_ = 0;

      y1_ = 0;

      x2_ = 0;

      y2_ = 0;

      x3_ = 0;

      y3_ = 0;

      x4_ = 0;

      y4_ = 0;

      type_ = "";

      label_ = "";

      vector_ = com.google.protobuf.ByteString.EMPTY;

      similarity_ = 0F;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return iie.grpc.VectorServer.internal_static_LocateEntry_descriptor;
    }

    @java.lang.Override
    public iie.grpc.LocateEntry getDefaultInstanceForType() {
      return iie.grpc.LocateEntry.getDefaultInstance();
    }

    @java.lang.Override
    public iie.grpc.LocateEntry build() {
      iie.grpc.LocateEntry result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public iie.grpc.LocateEntry buildPartial() {
      iie.grpc.LocateEntry result = new iie.grpc.LocateEntry(this);
      result.x1_ = x1_;
      result.y1_ = y1_;
      result.x2_ = x2_;
      result.y2_ = y2_;
      result.x3_ = x3_;
      result.y3_ = y3_;
      result.x4_ = x4_;
      result.y4_ = y4_;
      result.type_ = type_;
      result.label_ = label_;
      result.vector_ = vector_;
      result.similarity_ = similarity_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof iie.grpc.LocateEntry) {
        return mergeFrom((iie.grpc.LocateEntry)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(iie.grpc.LocateEntry other) {
      if (other == iie.grpc.LocateEntry.getDefaultInstance()) return this;
      if (other.getX1() != 0) {
        setX1(other.getX1());
      }
      if (other.getY1() != 0) {
        setY1(other.getY1());
      }
      if (other.getX2() != 0) {
        setX2(other.getX2());
      }
      if (other.getY2() != 0) {
        setY2(other.getY2());
      }
      if (other.getX3() != 0) {
        setX3(other.getX3());
      }
      if (other.getY3() != 0) {
        setY3(other.getY3());
      }
      if (other.getX4() != 0) {
        setX4(other.getX4());
      }
      if (other.getY4() != 0) {
        setY4(other.getY4());
      }
      if (!other.getType().isEmpty()) {
        type_ = other.type_;
        onChanged();
      }
      if (!other.getLabel().isEmpty()) {
        label_ = other.label_;
        onChanged();
      }
      if (other.getVector() != com.google.protobuf.ByteString.EMPTY) {
        setVector(other.getVector());
      }
      if (other.getSimilarity() != 0F) {
        setSimilarity(other.getSimilarity());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      iie.grpc.LocateEntry parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (iie.grpc.LocateEntry) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int x1_ ;
    /**
     * <code>sint32 x1 = 1;</code>
     */
    public int getX1() {
      return x1_;
    }
    /**
     * <code>sint32 x1 = 1;</code>
     */
    public Builder setX1(int value) {
      
      x1_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>sint32 x1 = 1;</code>
     */
    public Builder clearX1() {
      
      x1_ = 0;
      onChanged();
      return this;
    }

    private int y1_ ;
    /**
     * <code>sint32 y1 = 2;</code>
     */
    public int getY1() {
      return y1_;
    }
    /**
     * <code>sint32 y1 = 2;</code>
     */
    public Builder setY1(int value) {
      
      y1_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>sint32 y1 = 2;</code>
     */
    public Builder clearY1() {
      
      y1_ = 0;
      onChanged();
      return this;
    }

    private int x2_ ;
    /**
     * <code>sint32 x2 = 3;</code>
     */
    public int getX2() {
      return x2_;
    }
    /**
     * <code>sint32 x2 = 3;</code>
     */
    public Builder setX2(int value) {
      
      x2_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>sint32 x2 = 3;</code>
     */
    public Builder clearX2() {
      
      x2_ = 0;
      onChanged();
      return this;
    }

    private int y2_ ;
    /**
     * <code>sint32 y2 = 4;</code>
     */
    public int getY2() {
      return y2_;
    }
    /**
     * <code>sint32 y2 = 4;</code>
     */
    public Builder setY2(int value) {
      
      y2_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>sint32 y2 = 4;</code>
     */
    public Builder clearY2() {
      
      y2_ = 0;
      onChanged();
      return this;
    }

    private int x3_ ;
    /**
     * <code>sint32 x3 = 5;</code>
     */
    public int getX3() {
      return x3_;
    }
    /**
     * <code>sint32 x3 = 5;</code>
     */
    public Builder setX3(int value) {
      
      x3_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>sint32 x3 = 5;</code>
     */
    public Builder clearX3() {
      
      x3_ = 0;
      onChanged();
      return this;
    }

    private int y3_ ;
    /**
     * <code>sint32 y3 = 6;</code>
     */
    public int getY3() {
      return y3_;
    }
    /**
     * <code>sint32 y3 = 6;</code>
     */
    public Builder setY3(int value) {
      
      y3_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>sint32 y3 = 6;</code>
     */
    public Builder clearY3() {
      
      y3_ = 0;
      onChanged();
      return this;
    }

    private int x4_ ;
    /**
     * <code>sint32 x4 = 7;</code>
     */
    public int getX4() {
      return x4_;
    }
    /**
     * <code>sint32 x4 = 7;</code>
     */
    public Builder setX4(int value) {
      
      x4_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>sint32 x4 = 7;</code>
     */
    public Builder clearX4() {
      
      x4_ = 0;
      onChanged();
      return this;
    }

    private int y4_ ;
    /**
     * <code>sint32 y4 = 8;</code>
     */
    public int getY4() {
      return y4_;
    }
    /**
     * <code>sint32 y4 = 8;</code>
     */
    public Builder setY4(int value) {
      
      y4_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>sint32 y4 = 8;</code>
     */
    public Builder clearY4() {
      
      y4_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object type_ = "";
    /**
     * <code>string type = 9;</code>
     */
    public java.lang.String getType() {
      java.lang.Object ref = type_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        type_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string type = 9;</code>
     */
    public com.google.protobuf.ByteString
        getTypeBytes() {
      java.lang.Object ref = type_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        type_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string type = 9;</code>
     */
    public Builder setType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string type = 9;</code>
     */
    public Builder clearType() {
      
      type_ = getDefaultInstance().getType();
      onChanged();
      return this;
    }
    /**
     * <code>string type = 9;</code>
     */
    public Builder setTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      type_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object label_ = "";
    /**
     * <code>string label = 10;</code>
     */
    public java.lang.String getLabel() {
      java.lang.Object ref = label_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        label_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string label = 10;</code>
     */
    public com.google.protobuf.ByteString
        getLabelBytes() {
      java.lang.Object ref = label_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        label_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string label = 10;</code>
     */
    public Builder setLabel(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      label_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string label = 10;</code>
     */
    public Builder clearLabel() {
      
      label_ = getDefaultInstance().getLabel();
      onChanged();
      return this;
    }
    /**
     * <code>string label = 10;</code>
     */
    public Builder setLabelBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      label_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString vector_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes vector = 11;</code>
     */
    public com.google.protobuf.ByteString getVector() {
      return vector_;
    }
    /**
     * <code>bytes vector = 11;</code>
     */
    public Builder setVector(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      vector_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes vector = 11;</code>
     */
    public Builder clearVector() {
      
      vector_ = getDefaultInstance().getVector();
      onChanged();
      return this;
    }

    private float similarity_ ;
    /**
     * <code>float similarity = 12;</code>
     */
    public float getSimilarity() {
      return similarity_;
    }
    /**
     * <code>float similarity = 12;</code>
     */
    public Builder setSimilarity(float value) {
      
      similarity_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float similarity = 12;</code>
     */
    public Builder clearSimilarity() {
      
      similarity_ = 0F;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:LocateEntry)
  }

  // @@protoc_insertion_point(class_scope:LocateEntry)
  private static final iie.grpc.LocateEntry DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new iie.grpc.LocateEntry();
  }

  public static iie.grpc.LocateEntry getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LocateEntry>
      PARSER = new com.google.protobuf.AbstractParser<LocateEntry>() {
    @java.lang.Override
    public LocateEntry parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LocateEntry(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LocateEntry> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LocateEntry> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public iie.grpc.LocateEntry getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

