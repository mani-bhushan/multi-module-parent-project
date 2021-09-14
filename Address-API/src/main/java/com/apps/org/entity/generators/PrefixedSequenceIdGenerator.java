package com.apps.org.entity.generators;

import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(
        name = "gsn_seq",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "gsn_seq"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
        }
)
public class PrefixedSequenceIdGenerator implements Serializable {

	private static final long serialVersionUID = 4926468583005150701L;

//	public static final String DATE_FORMAT_PARAMETER = "dateFormat";
//    public static final String DATE_FORMAT_DEFAULT = "%tY-%tm";
//    public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
//    public static final String NUMBER_FORMAT_DEFAULT = "%05d";
//     
//    public static final String DATE_NUMBER_SEPARATOR_PARAMETER = "dateNumberSeparator";
//    public static final String DATE_NUMBER_SEPARATOR_DEFAULT = "_";
//     
//    private String format;
//    
//    @Override
//    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//        
//    	return String.format(format, LocalDate.now(), super.generate(session, object));
//    	
//    }
//    
//    @Override
//    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
//        
//    	super.configure(LongType.INSTANCE, params, serviceRegistry);
// 
//        String dateFormat = ConfigurationHelper.getString(DATE_FORMAT_PARAMETER, params, DATE_FORMAT_DEFAULT).replace("%", "%1"); 
//        
//        String numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT).replace("%", "%2"); 
//        
//        String dateNumberSeparator = ConfigurationHelper.getString(DATE_NUMBER_SEPARATOR_PARAMETER, params, DATE_NUMBER_SEPARATOR_DEFAULT); 
//
//        this.format = dateFormat+dateNumberSeparator+numberFormat; 
//    } 
}
