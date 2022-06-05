package com.taskmanager;

import org.junit.jupiter.api.BeforeEach;

import static org.mockito.MockitoAnnotations.openMocks;

public abstract class BaseTest {

    @BeforeEach
    void setupMocks() {
        openMocks(this);
    }
}
