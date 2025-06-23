package com.jgitundu8.ai_review_agent;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * @author Jackson G. Mwaniki
 */
public class SqlInjectionExampleTest {
    @Test
    void testFindUser() throws Exception {
        // Mock JDBC objects
        Connection mockConn = mock(Connection.class);
        Statement mockStmt = mock(Statement.class);
        ResultSet mockRs = mock(ResultSet.class);

        when(mockConn.createStatement()).thenReturn(mockStmt);
        when(mockStmt.executeQuery(anyString())).thenReturn(mockRs);
        when(mockRs.next()).thenReturn(true).thenReturn(false);
        when(mockRs.getString("username")).thenReturn("admin");

        // Mock static method DriverManager.getConnection
        try (MockedStatic<DriverManager> mocked = mockStatic(DriverManager.class)) {
            mocked.when(() -> DriverManager.getConnection(anyString(), anyString(), anyString()))
                    .thenReturn(mockConn);

            // Run actual code
            SqlInjectionExample example = new SqlInjectionExample();
            example.findUser("admin");

            // Verify query
            verify(mockStmt).executeQuery("SELECT * FROM users WHERE username = 'admin'");
        }
    }

}
