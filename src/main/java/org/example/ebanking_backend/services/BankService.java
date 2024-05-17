package org.example.ebanking_backend.services;


import jakarta.transaction.Transactional;
import org.example.ebanking_backend.entities.BankAccount;
import org.example.ebanking_backend.entities.CurrentAccount;
import org.example.ebanking_backend.entities.SavingAccount;
import org.example.ebanking_backend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BankService {

    @Autowired
    private BankAccountRepository bankAccoutRepository;
    public void consulter(){
        BankAccount bankAccount = bankAccoutRepository.findById("0bdccafe-45fc-4587-80a4-d92c557046d3").orElse(null);
        if(bankAccount!=null) {
            System.out.println("***********************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            System.out.println(bankAccount.getClass().getSimpleName());
            if (bankAccount instanceof CurrentAccount) {
                System.out.println("Over Daft -> " + ((CurrentAccount) bankAccount).getOverDraft());
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("Over Daft -> " + ((SavingAccount) bankAccount).getInterestRate());
            }

            bankAccount.getAccountOperationOperations().forEach(op -> {
                System.out.println(op.getType() + "\t" + op.getOperationDate() + "\t" + op.getAmmount());
            });
        }
    }
}
