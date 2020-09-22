import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'invoice',
        loadChildren: () => import('./accountancy/invoice/invoice.module').then(m => m.AccountancyInvoiceModule),
      },
      {
        path: 'shipment',
        loadChildren: () => import('./accountancy/shipment/shipment.module').then(m => m.AccountancyShipmentModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class StoreEntityModule {}
