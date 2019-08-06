package pwater.config;

import javax.sql.DataSource;

import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;


@SingletonConfig
public class DomaConfig implements Config {

	private static final DomaConfig INSTANCE = new DomaConfig();

	private final Dialect dialect;
	private final LocalTransactionDataSource dataSource;
	private final TransactionManager transactionManager;

	private DomaConfig() {
		dialect = new MysqlDialect();
		dataSource = new LocalTransactionDataSource(
            "jdbc:mysql://localhost:3306/hypernate",
            "ben_dev",
            "ben_pass"
        );
		transactionManager = new LocalTransactionManager(dataSource.getLocalTransaction(getJdbcLogger()));
	}

	@Override
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public Dialect getDialect() {
		return dialect;
	}

	@Override
	public TransactionManager getTransactionManager() {
		return transactionManager;
	}

	public static DomaConfig singleton() {
		return INSTANCE;
	}

}