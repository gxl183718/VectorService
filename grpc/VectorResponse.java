// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vector.proto

package iie.grpc;

/**
 * Protobuf type {@code VectorResponse}
 */
public  final class VectorResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:VectorResponse)
    VectorResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use VectorResponse.newBuilder() to construct.
  private VectorResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private VectorResponse() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private VectorResponse(
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
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              batchVector_ = com.google.protobuf.MapField.newMapField(
                  BatchVectorDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000001;
            }
            com.google.protobuf.MapEntry<java.lang.String, iie.grpc.MediaTask>
            batchVector__ = input.readMessage(
                BatchVectorDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            batchVector_.getMutableMap().put(
                batchVector__.getKey(), batchVector__.getValue());
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
    return iie.grpc.VectorServer.internal_static_VectorResponse_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 1:
        return internalGetBatchVector();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return iie.grpc.VectorServer.internal_static_VectorResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            iie.grpc.VectorResponse.class, iie.grpc.VectorResponse.Builder.class);
  }

  public static final int BATCHVECTOR_FIELD_NUMBER = 1;
  private static final class BatchVectorDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.String, iie.grpc.MediaTask> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, iie.grpc.MediaTask>newDefaultInstance(
                iie.grpc.VectorServer.internal_static_VectorResponse_BatchVectorEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.MESSAGE,
                iie.grpc.MediaTask.getDefaultInstance());
  }
  private com.google.protobuf.MapField<
      java.lang.String, iie.grpc.MediaTask> batchVector_;
  private com.google.protobuf.MapField<java.lang.String, iie.grpc.MediaTask>
  internalGetBatchVector() {
    if (batchVector_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          BatchVectorDefaultEntryHolder.defaultEntry);
    }
    return batchVector_;
  }

  public int getBatchVectorCount() {
    return internalGetBatchVector().getMap().size();
  }
  /**
   * <code>map&lt;string, .MediaTask&gt; batchVector = 1;</code>
   */

  public boolean containsBatchVector(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    return internalGetBatchVector().getMap().containsKey(key);
  }
  /**
   * Use {@link #getBatchVectorMap()} instead.
   */
  @java.lang.Deprecated
  public java.util.Map<java.lang.String, iie.grpc.MediaTask> getBatchVector() {
    return getBatchVectorMap();
  }
  /**
   * <code>map&lt;string, .MediaTask&gt; batchVector = 1;</code>
   */

  public java.util.Map<java.lang.String, iie.grpc.MediaTask> getBatchVectorMap() {
    return internalGetBatchVector().getMap();
  }
  /**
   * <code>map&lt;string, .MediaTask&gt; batchVector = 1;</code>
   */

  public iie.grpc.MediaTask getBatchVectorOrDefault(
      java.lang.String key,
      iie.grpc.MediaTask defaultValue) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, iie.grpc.MediaTask> map =
        internalGetBatchVector().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, .MediaTask&gt; batchVector = 1;</code>
   */

  public iie.grpc.MediaTask getBatchVectorOrThrow(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, iie.grpc.MediaTask> map =
        internalGetBatchVector().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
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
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetBatchVector(),
        BatchVectorDefaultEntryHolder.defaultEntry,
        1);
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (java.util.Map.Entry<java.lang.String, iie.grpc.MediaTask> entry
         : internalGetBatchVector().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, iie.grpc.MediaTask>
      batchVector__ = BatchVectorDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, batchVector__);
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
    if (!(obj instanceof iie.grpc.VectorResponse)) {
      return super.equals(obj);
    }
    iie.grpc.VectorResponse other = (iie.grpc.VectorResponse) obj;

    if (!internalGetBatchVector().equals(
        other.internalGetBatchVector())) return false;
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
    if (!internalGetBatchVector().getMap().isEmpty()) {
      hash = (37 * hash) + BATCHVECTOR_FIELD_NUMBER;
      hash = (53 * hash) + internalGetBatchVector().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static iie.grpc.VectorResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static iie.grpc.VectorResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static iie.grpc.VectorResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static iie.grpc.VectorResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static iie.grpc.VectorResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static iie.grpc.VectorResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static iie.grpc.VectorResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static iie.grpc.VectorResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static iie.grpc.VectorResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static iie.grpc.VectorResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static iie.grpc.VectorResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static iie.grpc.VectorResponse parseFrom(
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
  public static Builder newBuilder(iie.grpc.VectorResponse prototype) {
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
   * Protobuf type {@code VectorResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:VectorResponse)
      iie.grpc.VectorResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return iie.grpc.VectorServer.internal_static_VectorResponse_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetBatchVector();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetMutableBatchVector();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return iie.grpc.VectorServer.internal_static_VectorResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              iie.grpc.VectorResponse.class, iie.grpc.VectorResponse.Builder.class);
    }

    // Construct using iie.grpc.VectorResponse.newBuilder()
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
      internalGetMutableBatchVector().clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return iie.grpc.VectorServer.internal_static_VectorResponse_descriptor;
    }

    @java.lang.Override
    public iie.grpc.VectorResponse getDefaultInstanceForType() {
      return iie.grpc.VectorResponse.getDefaultInstance();
    }

    @java.lang.Override
    public iie.grpc.VectorResponse build() {
      iie.grpc.VectorResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public iie.grpc.VectorResponse buildPartial() {
      iie.grpc.VectorResponse result = new iie.grpc.VectorResponse(this);
      int from_bitField0_ = bitField0_;
      result.batchVector_ = internalGetBatchVector();
      result.batchVector_.makeImmutable();
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
      if (other instanceof iie.grpc.VectorResponse) {
        return mergeFrom((iie.grpc.VectorResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(iie.grpc.VectorResponse other) {
      if (other == iie.grpc.VectorResponse.getDefaultInstance()) return this;
      internalGetMutableBatchVector().mergeFrom(
          other.internalGetBatchVector());
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
      iie.grpc.VectorResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (iie.grpc.VectorResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.MapField<
        java.lang.String, iie.grpc.MediaTask> batchVector_;
    private com.google.protobuf.MapField<java.lang.String, iie.grpc.MediaTask>
    internalGetBatchVector() {
      if (batchVector_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            BatchVectorDefaultEntryHolder.defaultEntry);
      }
      return batchVector_;
    }
    private com.google.protobuf.MapField<java.lang.String, iie.grpc.MediaTask>
    internalGetMutableBatchVector() {
      onChanged();;
      if (batchVector_ == null) {
        batchVector_ = com.google.protobuf.MapField.newMapField(
            BatchVectorDefaultEntryHolder.defaultEntry);
      }
      if (!batchVector_.isMutable()) {
        batchVector_ = batchVector_.copy();
      }
      return batchVector_;
    }

    public int getBatchVectorCount() {
      return internalGetBatchVector().getMap().size();
    }
    /**
     * <code>map&lt;string, .MediaTask&gt; batchVector = 1;</code>
     */

    public boolean containsBatchVector(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetBatchVector().getMap().containsKey(key);
    }
    /**
     * Use {@link #getBatchVectorMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, iie.grpc.MediaTask> getBatchVector() {
      return getBatchVectorMap();
    }
    /**
     * <code>map&lt;string, .MediaTask&gt; batchVector = 1;</code>
     */

    public java.util.Map<java.lang.String, iie.grpc.MediaTask> getBatchVectorMap() {
      return internalGetBatchVector().getMap();
    }
    /**
     * <code>map&lt;string, .MediaTask&gt; batchVector = 1;</code>
     */

    public iie.grpc.MediaTask getBatchVectorOrDefault(
        java.lang.String key,
        iie.grpc.MediaTask defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, iie.grpc.MediaTask> map =
          internalGetBatchVector().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, .MediaTask&gt; batchVector = 1;</code>
     */

    public iie.grpc.MediaTask getBatchVectorOrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, iie.grpc.MediaTask> map =
          internalGetBatchVector().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearBatchVector() {
      internalGetMutableBatchVector().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;string, .MediaTask&gt; batchVector = 1;</code>
     */

    public Builder removeBatchVector(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableBatchVector().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, iie.grpc.MediaTask>
    getMutableBatchVector() {
      return internalGetMutableBatchVector().getMutableMap();
    }
    /**
     * <code>map&lt;string, .MediaTask&gt; batchVector = 1;</code>
     */
    public Builder putBatchVector(
        java.lang.String key,
        iie.grpc.MediaTask value) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      if (value == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableBatchVector().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;string, .MediaTask&gt; batchVector = 1;</code>
     */

    public Builder putAllBatchVector(
        java.util.Map<java.lang.String, iie.grpc.MediaTask> values) {
      internalGetMutableBatchVector().getMutableMap()
          .putAll(values);
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


    // @@protoc_insertion_point(builder_scope:VectorResponse)
  }

  // @@protoc_insertion_point(class_scope:VectorResponse)
  private static final iie.grpc.VectorResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new iie.grpc.VectorResponse();
  }

  public static iie.grpc.VectorResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<VectorResponse>
      PARSER = new com.google.protobuf.AbstractParser<VectorResponse>() {
    @java.lang.Override
    public VectorResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new VectorResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<VectorResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<VectorResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public iie.grpc.VectorResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
