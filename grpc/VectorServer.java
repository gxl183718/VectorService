// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vector.proto

package iie.grpc;

public final class VectorServer {
  private VectorServer() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Test_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Test_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_VectorRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_VectorRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_VectorRequest_BatchQueryEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_VectorRequest_BatchQueryEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MediaTask_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MediaTask_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MediaTask_ImageVectorsEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MediaTask_ImageVectorsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_VectorResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_VectorResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_VectorResponse_BatchVectorEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_VectorResponse_BatchVectorEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ImageBytes_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ImageBytes_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ImageUrl_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ImageUrl_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LocateEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LocateEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LocateEntries_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LocateEntries_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_BytesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BytesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UrlRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UrlRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_BytesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BytesResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_QueryByBytesEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_QueryByBytesEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_QueryByUrlEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_QueryByUrlEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ResultEntryHash_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ResultEntryHash_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ResultEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ResultEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014vector.proto\"\024\n\004Test\022\014\n\004name\030\001 \001(\t\"v\n\r" +
      "VectorRequest\0222\n\nbatchQuery\030\001 \003(\0132\036.Vect" +
      "orRequest.BatchQueryEntry\0321\n\017BatchQueryE" +
      "ntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001\"\246\001\n" +
      "\tMediaTask\022\021\n\timage_url\030\001 \001(\t\022\014\n\004code\030\002 " +
      "\001(\t\022\016\n\006failed\030\003 \001(\t\0223\n\rimage_vectors\030\004 \003" +
      "(\0132\034.MediaTask.ImageVectorsEntry\0323\n\021Imag" +
      "eVectorsEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(" +
      "\014:\0028\001\"\207\001\n\016VectorResponse\0225\n\013batchVector\030" +
      "\001 \003(\0132 .VectorResponse.BatchVectorEntry\032" +
      ">\n\020BatchVectorEntry\022\013\n\003key\030\001 \001(\t\022\031\n\005valu" +
      "e\030\002 \001(\0132\n.MediaTask:\0028\001\"\033\n\nImageBytes\022\r\n" +
      "\005image\030\001 \001(\014\"\027\n\010ImageUrl\022\013\n\003url\030\001 \001(\t\"\256\001" +
      "\n\013LocateEntry\022\n\n\002x1\030\001 \001(\021\022\n\n\002y1\030\002 \001(\021\022\n\n" +
      "\002x2\030\003 \001(\021\022\n\n\002y2\030\004 \001(\021\022\n\n\002x3\030\005 \001(\021\022\n\n\002y3\030" +
      "\006 \001(\021\022\n\n\002x4\030\007 \001(\021\022\n\n\002y4\030\010 \001(\021\022\014\n\004type\030\t " +
      "\001(\t\022\r\n\005label\030\n \001(\t\022\016\n\006vector\030\013 \001(\014\022\022\n\nsi" +
      "milarity\030\014 \001(\002\"R\n\rLocateEntries\022\035\n\007locat" +
      "es\030\001 \003(\0132\014.LocateEntry\022\014\n\004code\030\002 \001(\t\022\t\n\001" +
      "w\030\003 \001(\021\022\t\n\001h\030\004 \001(\021\"\202\001\n\014BytesRequest\022\n\n\002x" +
      "1\030\001 \001(\021\022\n\n\002y1\030\002 \001(\021\022\n\n\002x2\030\003 \001(\021\022\n\n\002y2\030\004 " +
      "\001(\021\022\n\n\002x3\030\005 \001(\021\022\n\n\002y3\030\006 \001(\021\022\n\n\002x4\030\007 \001(\021\022" +
      "\n\n\002y4\030\010 \001(\021\022\022\n\nimageBytes\030\t \001(\014\"~\n\nUrlRe" +
      "quest\022\n\n\002x1\030\001 \001(\021\022\n\n\002y1\030\002 \001(\021\022\n\n\002x2\030\003 \001(" +
      "\021\022\n\n\002y2\030\004 \001(\021\022\n\n\002x3\030\005 \001(\021\022\n\n\002y3\030\006 \001(\021\022\n\n" +
      "\002x4\030\007 \001(\021\022\n\n\002y4\030\010 \001(\021\022\020\n\010imageUrl\030\t \001(\t\"" +
      "2\n\rBytesResponse\022\023\n\013vectorBytes\030\001 \001(\014\022\014\n" +
      "\004code\030\002 \001(\t\"d\n\021QueryByBytesEntry\022\r\n\005spac" +
      "e\030\001 \001(\t\022\021\n\tstartTime\030\002 \001(\003\022\017\n\007endTime\030\003 " +
      "\001(\003\022\034\n\005image\030\010 \001(\0132\r.BytesRequest\"`\n\017Que" +
      "ryByUrlEntry\022\r\n\005space\030\001 \001(\t\022\021\n\tstartTime" +
      "\030\002 \001(\003\022\017\n\007endTime\030\003 \001(\003\022\032\n\005image\030\004 \001(\0132\013" +
      ".UrlRequest\"6\n\017ResultEntryHash\022#\n\rResult" +
      "Entries\030\001 \003(\0132\014.ResultEntry\"a\n\013ResultEnt" +
      "ry\022\r\n\005space\030\001 \001(\t\022\017\n\007version\030\002 \001(\t\022\021\n\tst" +
      "artTime\030\003 \001(\003\022\017\n\007endTime\030\004 \001(\003\022\016\n\006vector" +
      "\030\005 \001(\0142\201\003\n\006Vector\022\026\n\004test\022\005.Test\032\005.Test\"" +
      "\000\022+\n\006search\022\016.VectorRequest\032\017.VectorResp" +
      "onse\"\000\0220\n\021getObjectsByBytes\022\013.ImageBytes" +
      "\032\016.LocateEntries\022,\n\017getObjectsByUrl\022\t.Im" +
      "ageUrl\032\016.LocateEntries\0220\n\rsearchByBytes\022" +
      "\r.BytesRequest\032\016.BytesResponse\"\000\022,\n\013sear" +
      "chByUrl\022\013.UrlRequest\032\016.BytesResponse\"\000\022:" +
      "\n\020getVectorByBytes\022\022.QueryByBytesEntry\032\020" +
      ".ResultEntryHash\"\000\0226\n\016getVectorByUrl\022\020.Q" +
      "ueryByUrlEntry\032\020.ResultEntryHash\"\000B\032\n\010ii" +
      "e.grpcB\014VectorServerP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Test_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Test_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Test_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_VectorRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_VectorRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_VectorRequest_descriptor,
        new java.lang.String[] { "BatchQuery", });
    internal_static_VectorRequest_BatchQueryEntry_descriptor =
      internal_static_VectorRequest_descriptor.getNestedTypes().get(0);
    internal_static_VectorRequest_BatchQueryEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_VectorRequest_BatchQueryEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_MediaTask_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_MediaTask_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MediaTask_descriptor,
        new java.lang.String[] { "ImageUrl", "Code", "Failed", "ImageVectors", });
    internal_static_MediaTask_ImageVectorsEntry_descriptor =
      internal_static_MediaTask_descriptor.getNestedTypes().get(0);
    internal_static_MediaTask_ImageVectorsEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MediaTask_ImageVectorsEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_VectorResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_VectorResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_VectorResponse_descriptor,
        new java.lang.String[] { "BatchVector", });
    internal_static_VectorResponse_BatchVectorEntry_descriptor =
      internal_static_VectorResponse_descriptor.getNestedTypes().get(0);
    internal_static_VectorResponse_BatchVectorEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_VectorResponse_BatchVectorEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_ImageBytes_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ImageBytes_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ImageBytes_descriptor,
        new java.lang.String[] { "Image", });
    internal_static_ImageUrl_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_ImageUrl_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ImageUrl_descriptor,
        new java.lang.String[] { "Url", });
    internal_static_LocateEntry_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_LocateEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LocateEntry_descriptor,
        new java.lang.String[] { "X1", "Y1", "X2", "Y2", "X3", "Y3", "X4", "Y4", "Type", "Label", "Vector", "Similarity", });
    internal_static_LocateEntries_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_LocateEntries_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LocateEntries_descriptor,
        new java.lang.String[] { "Locates", "Code", "W", "H", });
    internal_static_BytesRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_BytesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_BytesRequest_descriptor,
        new java.lang.String[] { "X1", "Y1", "X2", "Y2", "X3", "Y3", "X4", "Y4", "ImageBytes", });
    internal_static_UrlRequest_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_UrlRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UrlRequest_descriptor,
        new java.lang.String[] { "X1", "Y1", "X2", "Y2", "X3", "Y3", "X4", "Y4", "ImageUrl", });
    internal_static_BytesResponse_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_BytesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_BytesResponse_descriptor,
        new java.lang.String[] { "VectorBytes", "Code", });
    internal_static_QueryByBytesEntry_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_QueryByBytesEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_QueryByBytesEntry_descriptor,
        new java.lang.String[] { "Space", "StartTime", "EndTime", "Image", });
    internal_static_QueryByUrlEntry_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_QueryByUrlEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_QueryByUrlEntry_descriptor,
        new java.lang.String[] { "Space", "StartTime", "EndTime", "Image", });
    internal_static_ResultEntryHash_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_ResultEntryHash_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ResultEntryHash_descriptor,
        new java.lang.String[] { "ResultEntries", });
    internal_static_ResultEntry_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_ResultEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ResultEntry_descriptor,
        new java.lang.String[] { "Space", "Version", "StartTime", "EndTime", "Vector", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}