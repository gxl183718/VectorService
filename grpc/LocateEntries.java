// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vector.proto

package iie.grpc;

/**
 * Protobuf type {@code LocateEntries}
 */
public  final class LocateEntries extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:LocateEntries)
    LocateEntriesOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LocateEntries.newBuilder() to construct.
  private LocateEntries(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LocateEntries() {
    locates_ = java.util.Collections.emptyList();
    code_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LocateEntries(
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
              locates_ = new java.util.ArrayList<iie.grpc.LocateEntry>();
              mutable_bitField0_ |= 0x00000001;
            }
            locates_.add(
                input.readMessage(iie.grpc.LocateEntry.parser(), extensionRegistry));
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            code_ = s;
            break;
          }
          case 24: {

            w_ = input.readSInt32();
            break;
          }
          case 32: {

            h_ = input.readSInt32();
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        locates_ = java.util.Collections.unmodifiableList(locates_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return iie.grpc.VectorServer.internal_static_LocateEntries_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return iie.grpc.VectorServer.internal_static_LocateEntries_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            iie.grpc.LocateEntries.class, iie.grpc.LocateEntries.Builder.class);
  }

  private int bitField0_;
  public static final int LOCATES_FIELD_NUMBER = 1;
  private java.util.List<iie.grpc.LocateEntry> locates_;
  /**
   * <code>repeated .LocateEntry locates = 1;</code>
   */
  public java.util.List<iie.grpc.LocateEntry> getLocatesList() {
    return locates_;
  }
  /**
   * <code>repeated .LocateEntry locates = 1;</code>
   */
  public java.util.List<? extends iie.grpc.LocateEntryOrBuilder> 
      getLocatesOrBuilderList() {
    return locates_;
  }
  /**
   * <code>repeated .LocateEntry locates = 1;</code>
   */
  public int getLocatesCount() {
    return locates_.size();
  }
  /**
   * <code>repeated .LocateEntry locates = 1;</code>
   */
  public iie.grpc.LocateEntry getLocates(int index) {
    return locates_.get(index);
  }
  /**
   * <code>repeated .LocateEntry locates = 1;</code>
   */
  public iie.grpc.LocateEntryOrBuilder getLocatesOrBuilder(
      int index) {
    return locates_.get(index);
  }

  public static final int CODE_FIELD_NUMBER = 2;
  private volatile java.lang.Object code_;
  /**
   * <pre>
   *0：正常 -1：异常
   * </pre>
   *
   * <code>string code = 2;</code>
   */
  public java.lang.String getCode() {
    java.lang.Object ref = code_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      code_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *0：正常 -1：异常
   * </pre>
   *
   * <code>string code = 2;</code>
   */
  public com.google.protobuf.ByteString
      getCodeBytes() {
    java.lang.Object ref = code_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      code_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int W_FIELD_NUMBER = 3;
  private int w_;
  /**
   * <code>sint32 w = 3;</code>
   */
  public int getW() {
    return w_;
  }

  public static final int H_FIELD_NUMBER = 4;
  private int h_;
  /**
   * <code>sint32 h = 4;</code>
   */
  public int getH() {
    return h_;
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
    for (int i = 0; i < locates_.size(); i++) {
      output.writeMessage(1, locates_.get(i));
    }
    if (!getCodeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, code_);
    }
    if (w_ != 0) {
      output.writeSInt32(3, w_);
    }
    if (h_ != 0) {
      output.writeSInt32(4, h_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < locates_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, locates_.get(i));
    }
    if (!getCodeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, code_);
    }
    if (w_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(3, w_);
    }
    if (h_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(4, h_);
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
    if (!(obj instanceof iie.grpc.LocateEntries)) {
      return super.equals(obj);
    }
    iie.grpc.LocateEntries other = (iie.grpc.LocateEntries) obj;

    if (!getLocatesList()
        .equals(other.getLocatesList())) return false;
    if (!getCode()
        .equals(other.getCode())) return false;
    if (getW()
        != other.getW()) return false;
    if (getH()
        != other.getH()) return false;
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
    if (getLocatesCount() > 0) {
      hash = (37 * hash) + LOCATES_FIELD_NUMBER;
      hash = (53 * hash) + getLocatesList().hashCode();
    }
    hash = (37 * hash) + CODE_FIELD_NUMBER;
    hash = (53 * hash) + getCode().hashCode();
    hash = (37 * hash) + W_FIELD_NUMBER;
    hash = (53 * hash) + getW();
    hash = (37 * hash) + H_FIELD_NUMBER;
    hash = (53 * hash) + getH();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static iie.grpc.LocateEntries parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static iie.grpc.LocateEntries parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static iie.grpc.LocateEntries parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static iie.grpc.LocateEntries parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static iie.grpc.LocateEntries parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static iie.grpc.LocateEntries parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static iie.grpc.LocateEntries parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static iie.grpc.LocateEntries parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static iie.grpc.LocateEntries parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static iie.grpc.LocateEntries parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static iie.grpc.LocateEntries parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static iie.grpc.LocateEntries parseFrom(
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
  public static Builder newBuilder(iie.grpc.LocateEntries prototype) {
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
   * Protobuf type {@code LocateEntries}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:LocateEntries)
      iie.grpc.LocateEntriesOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return iie.grpc.VectorServer.internal_static_LocateEntries_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return iie.grpc.VectorServer.internal_static_LocateEntries_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              iie.grpc.LocateEntries.class, iie.grpc.LocateEntries.Builder.class);
    }

    // Construct using iie.grpc.LocateEntries.newBuilder()
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
        getLocatesFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (locatesBuilder_ == null) {
        locates_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        locatesBuilder_.clear();
      }
      code_ = "";

      w_ = 0;

      h_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return iie.grpc.VectorServer.internal_static_LocateEntries_descriptor;
    }

    @java.lang.Override
    public iie.grpc.LocateEntries getDefaultInstanceForType() {
      return iie.grpc.LocateEntries.getDefaultInstance();
    }

    @java.lang.Override
    public iie.grpc.LocateEntries build() {
      iie.grpc.LocateEntries result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public iie.grpc.LocateEntries buildPartial() {
      iie.grpc.LocateEntries result = new iie.grpc.LocateEntries(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (locatesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          locates_ = java.util.Collections.unmodifiableList(locates_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.locates_ = locates_;
      } else {
        result.locates_ = locatesBuilder_.build();
      }
      result.code_ = code_;
      result.w_ = w_;
      result.h_ = h_;
      result.bitField0_ = to_bitField0_;
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
      if (other instanceof iie.grpc.LocateEntries) {
        return mergeFrom((iie.grpc.LocateEntries)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(iie.grpc.LocateEntries other) {
      if (other == iie.grpc.LocateEntries.getDefaultInstance()) return this;
      if (locatesBuilder_ == null) {
        if (!other.locates_.isEmpty()) {
          if (locates_.isEmpty()) {
            locates_ = other.locates_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureLocatesIsMutable();
            locates_.addAll(other.locates_);
          }
          onChanged();
        }
      } else {
        if (!other.locates_.isEmpty()) {
          if (locatesBuilder_.isEmpty()) {
            locatesBuilder_.dispose();
            locatesBuilder_ = null;
            locates_ = other.locates_;
            bitField0_ = (bitField0_ & ~0x00000001);
            locatesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getLocatesFieldBuilder() : null;
          } else {
            locatesBuilder_.addAllMessages(other.locates_);
          }
        }
      }
      if (!other.getCode().isEmpty()) {
        code_ = other.code_;
        onChanged();
      }
      if (other.getW() != 0) {
        setW(other.getW());
      }
      if (other.getH() != 0) {
        setH(other.getH());
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
      iie.grpc.LocateEntries parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (iie.grpc.LocateEntries) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<iie.grpc.LocateEntry> locates_ =
      java.util.Collections.emptyList();
    private void ensureLocatesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        locates_ = new java.util.ArrayList<iie.grpc.LocateEntry>(locates_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        iie.grpc.LocateEntry, iie.grpc.LocateEntry.Builder, iie.grpc.LocateEntryOrBuilder> locatesBuilder_;

    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public java.util.List<iie.grpc.LocateEntry> getLocatesList() {
      if (locatesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(locates_);
      } else {
        return locatesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public int getLocatesCount() {
      if (locatesBuilder_ == null) {
        return locates_.size();
      } else {
        return locatesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public iie.grpc.LocateEntry getLocates(int index) {
      if (locatesBuilder_ == null) {
        return locates_.get(index);
      } else {
        return locatesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public Builder setLocates(
        int index, iie.grpc.LocateEntry value) {
      if (locatesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLocatesIsMutable();
        locates_.set(index, value);
        onChanged();
      } else {
        locatesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public Builder setLocates(
        int index, iie.grpc.LocateEntry.Builder builderForValue) {
      if (locatesBuilder_ == null) {
        ensureLocatesIsMutable();
        locates_.set(index, builderForValue.build());
        onChanged();
      } else {
        locatesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public Builder addLocates(iie.grpc.LocateEntry value) {
      if (locatesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLocatesIsMutable();
        locates_.add(value);
        onChanged();
      } else {
        locatesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public Builder addLocates(
        int index, iie.grpc.LocateEntry value) {
      if (locatesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLocatesIsMutable();
        locates_.add(index, value);
        onChanged();
      } else {
        locatesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public Builder addLocates(
        iie.grpc.LocateEntry.Builder builderForValue) {
      if (locatesBuilder_ == null) {
        ensureLocatesIsMutable();
        locates_.add(builderForValue.build());
        onChanged();
      } else {
        locatesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public Builder addLocates(
        int index, iie.grpc.LocateEntry.Builder builderForValue) {
      if (locatesBuilder_ == null) {
        ensureLocatesIsMutable();
        locates_.add(index, builderForValue.build());
        onChanged();
      } else {
        locatesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public Builder addAllLocates(
        java.lang.Iterable<? extends iie.grpc.LocateEntry> values) {
      if (locatesBuilder_ == null) {
        ensureLocatesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, locates_);
        onChanged();
      } else {
        locatesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public Builder clearLocates() {
      if (locatesBuilder_ == null) {
        locates_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        locatesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public Builder removeLocates(int index) {
      if (locatesBuilder_ == null) {
        ensureLocatesIsMutable();
        locates_.remove(index);
        onChanged();
      } else {
        locatesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public iie.grpc.LocateEntry.Builder getLocatesBuilder(
        int index) {
      return getLocatesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public iie.grpc.LocateEntryOrBuilder getLocatesOrBuilder(
        int index) {
      if (locatesBuilder_ == null) {
        return locates_.get(index);  } else {
        return locatesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public java.util.List<? extends iie.grpc.LocateEntryOrBuilder> 
         getLocatesOrBuilderList() {
      if (locatesBuilder_ != null) {
        return locatesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(locates_);
      }
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public iie.grpc.LocateEntry.Builder addLocatesBuilder() {
      return getLocatesFieldBuilder().addBuilder(
          iie.grpc.LocateEntry.getDefaultInstance());
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public iie.grpc.LocateEntry.Builder addLocatesBuilder(
        int index) {
      return getLocatesFieldBuilder().addBuilder(
          index, iie.grpc.LocateEntry.getDefaultInstance());
    }
    /**
     * <code>repeated .LocateEntry locates = 1;</code>
     */
    public java.util.List<iie.grpc.LocateEntry.Builder> 
         getLocatesBuilderList() {
      return getLocatesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        iie.grpc.LocateEntry, iie.grpc.LocateEntry.Builder, iie.grpc.LocateEntryOrBuilder> 
        getLocatesFieldBuilder() {
      if (locatesBuilder_ == null) {
        locatesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            iie.grpc.LocateEntry, iie.grpc.LocateEntry.Builder, iie.grpc.LocateEntryOrBuilder>(
                locates_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        locates_ = null;
      }
      return locatesBuilder_;
    }

    private java.lang.Object code_ = "";
    /**
     * <pre>
     *0：正常 -1：异常
     * </pre>
     *
     * <code>string code = 2;</code>
     */
    public java.lang.String getCode() {
      java.lang.Object ref = code_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        code_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *0：正常 -1：异常
     * </pre>
     *
     * <code>string code = 2;</code>
     */
    public com.google.protobuf.ByteString
        getCodeBytes() {
      java.lang.Object ref = code_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        code_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *0：正常 -1：异常
     * </pre>
     *
     * <code>string code = 2;</code>
     */
    public Builder setCode(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      code_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *0：正常 -1：异常
     * </pre>
     *
     * <code>string code = 2;</code>
     */
    public Builder clearCode() {
      
      code_ = getDefaultInstance().getCode();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *0：正常 -1：异常
     * </pre>
     *
     * <code>string code = 2;</code>
     */
    public Builder setCodeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      code_ = value;
      onChanged();
      return this;
    }

    private int w_ ;
    /**
     * <code>sint32 w = 3;</code>
     */
    public int getW() {
      return w_;
    }
    /**
     * <code>sint32 w = 3;</code>
     */
    public Builder setW(int value) {
      
      w_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>sint32 w = 3;</code>
     */
    public Builder clearW() {
      
      w_ = 0;
      onChanged();
      return this;
    }

    private int h_ ;
    /**
     * <code>sint32 h = 4;</code>
     */
    public int getH() {
      return h_;
    }
    /**
     * <code>sint32 h = 4;</code>
     */
    public Builder setH(int value) {
      
      h_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>sint32 h = 4;</code>
     */
    public Builder clearH() {
      
      h_ = 0;
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


    // @@protoc_insertion_point(builder_scope:LocateEntries)
  }

  // @@protoc_insertion_point(class_scope:LocateEntries)
  private static final iie.grpc.LocateEntries DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new iie.grpc.LocateEntries();
  }

  public static iie.grpc.LocateEntries getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LocateEntries>
      PARSER = new com.google.protobuf.AbstractParser<LocateEntries>() {
    @java.lang.Override
    public LocateEntries parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LocateEntries(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LocateEntries> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LocateEntries> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public iie.grpc.LocateEntries getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

