/*
 * Copyright 2023 Datastrato.
 * This software is licensed under the Apache License version 2.
 */
package com.datastrato.graviton.catalog;

import com.datastrato.graviton.rel.SupportsSchemas;
import com.datastrato.graviton.rel.TableCatalog;
import java.io.Closeable;
import java.util.Map;

/**
 * A catalog operation interface that is used to trigger the operations of a catalog. This interface
 * should be mixed with other Catalog interface like {@link SupportsSchemas} to provide schema
 * operation, {@link TableCatalog} to support table operations, etc.
 */
public interface CatalogOperations extends Closeable {

  /**
   * Initialize the CatalogOperation with specified configuration. This method is called after
   * CatalogOperation object is created, but before any other method is called. The method is used
   * to initialize the connection to the underlying metadata source. RuntimeException will be thrown
   * if the initialization failed.
   *
   * @param config The configuration of this Catalog.
   * @throws RuntimeException if the initialization failed.
   */
  void initialize(Map<String, String> config) throws RuntimeException;
}